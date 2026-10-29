package net.msrandom.minecraftcodev.includes

import org.gradle.api.GradleException
import org.gradle.api.artifacts.ExternalModuleDependency
import org.gradle.api.artifacts.component.ComponentArtifactIdentifier
import org.gradle.api.artifacts.component.ComponentIdentifier
import org.gradle.api.artifacts.component.ComponentSelector
import org.gradle.api.artifacts.component.ModuleComponentIdentifier
import org.gradle.api.artifacts.component.ProjectComponentIdentifier
import org.gradle.api.artifacts.result.DependencyResult
import org.gradle.api.artifacts.result.ResolvedArtifactResult
import org.gradle.api.artifacts.result.ResolvedComponentResult
import org.gradle.api.artifacts.result.ResolvedDependencyResult
import org.gradle.api.artifacts.result.ResolvedVariantResult
import org.gradle.api.artifacts.result.UnresolvedDependencyResult
import org.gradle.api.attributes.Attribute
import org.gradle.api.attributes.AttributeContainer
import org.gradle.api.capabilities.Capability
import org.gradle.api.logging.Logger
import org.gradle.testfixtures.ProjectBuilder
import org.gradle.testkit.runner.BuildResult
import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.TaskOutcome
import org.gradle.testkit.runner.UnexpectedBuildFailure
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File
import java.lang.reflect.Proxy
import java.nio.file.Files
import java.nio.file.Path

class IncludedJarInfoIdentityTests {
    private val fixtures = Path.of("build/reports/test/fixtures").toAbsolutePath()
    private val project by lazy {
        val directory = Files.createTempDirectory(Files.createDirectories(fixtures), "model-")
        ProjectBuilder.builder().withName("consumer").withProjectDir(directory.toFile()).build().also {
            it.repositories.maven { url = directory.resolve("empty-repository").toUri() }
        }
    }
    private val warnings = mutableListOf<String>()
    private val logger = stub<Logger> { method, arguments ->
        check(method == "warn") { "Unexpected logger method $method" }
        warnings.add(arguments[0] as String)
        null
    }

    @Test
    fun realJavaProjectRequestUsesPublicExtractionAndLocalImplementation() {
        val result = runJavaFixture()
        assertEquals(TaskOutcome.SUCCESS, result.task(":verifyIdentity")?.outcome)
        assertTrue(result.output.contains("IDENTITY chosen:producer-extra:3.2 [3.2,)"))
        assertTrue(result.output.contains("SELECTED project :producer"))
    }

    @Test
    fun realJavaMultipleSourcesTaskApiPreservesProducerDependencies() {
        for (scenario in listOf("strict", "required", "preferred", "project", "target-only", "default", "ambiguous")) {
            val result = runJavaFixture(scenario)
            if (scenario == "ambiguous") {
                assertTrue(result.output.contains("Ambiguous capability identities"), result.output)
                assertTrue(result.output.contains("ordinary:producer"))
                assertTrue(result.output.contains("chosen:producer-a"))
                assertTrue(result.output.contains("source[0]=ordinary, variant aRuntimeElements"))
                assertTrue(result.output.contains("targetName=demo:a"))
                assertTrue(result.output.contains("requests chosen:producer-a, ordinary:producer from"))
            } else {
                assertEquals(TaskOutcome.SUCCESS, result.task(":gatheredIncludes")?.outcome)
                val producers = if (scenario == "default") listOf("jar") else listOf("aPayload", "aSources", "bPayload")
                producers.forEach { assertEquals(TaskOutcome.SUCCESS, result.task(":producer:$it")?.outcome, "$scenario $it") }
                assertTrue(result.output.contains("GATHERED $scenario"))
                assertTrue(result.output.contains("CONFIGURATION_UNRESOLVED"))
                assertTrue(result.output.contains("PRODUCER_TASK"))
            }
        }
    }

    private fun runJavaFixture(scenario: String? = null): BuildResult {
        println("TEST_TOOLCHAIN ${System.getProperty("java.version")} ${System.getProperty("java.home")}")
        val localBuild = Path.of("build").toRealPath()
        listOf(
            IncludedJarInfo::class.java, IncludesJar::class.java, IncludeTargetOrigin::class.java,
            IncludeTargetSource::class.java, ResolvedIncludeSource::class.java,
        ).forEach {
            val source = Path.of(it.protectionDomain.codeSource.location.toURI()).toRealPath()
            assertTrue(source.startsWith(localBuild))
            assertEquals(1, it.classLoader.getResources(it.name.replace('.', '/') + ".class").toList().size)
            println("CODE_SOURCE ${it.name} $source")
        }
        val directory = Files.createTempDirectory(Files.createDirectories(fixtures), "java-${scenario ?: "smoke"}-")
        println("SMOKE_FIXTURE $directory")
        val source = Path.of("src/test/resources/include-identity")
        listOf("settings.gradle", "build.gradle", "producer/build.gradle", "producer/src/main/java/smoke/Payload.java").forEach {
            val destination = directory.resolve(it)
            Files.createDirectories(destination.parent)
            Files.copy(source.resolve(it), destination)
        }
        val home = File(checkNotNull(System.getProperty("fixture.gradleUserHome")))
        assertEquals(home.canonicalFile, File(checkNotNull(System.getProperty("org.gradle.testkit.dir"))).canonicalFile)
        val runner = GradleRunner.create().withProjectDir(directory.toFile()).withPluginClasspath().withTestKitDir(home)
        assertFalse(runner.pluginClasspath.any { it.name.matches(Regex("minecraft-codev-includes-.*\\.jar")) })
        try {
            runner.withArguments(listOf(
                if (scenario == null) "verifyIdentity" else "gatheredIncludes",
                "--stacktrace", "--max-workers=1", "--no-configuration-cache",
                "--gradle-user-home", home.absolutePath,
                "-Dorg.gradle.java.home=" + System.getProperty("fixture.gradleJava"),
                "-PlocalIncludesBuild=$localBuild",
            ) + scenario?.let { listOf("-PsourceScenario=$it") }.orEmpty())
            val result = if (scenario == "ambiguous") runner.buildAndFail() else runner.build()
            Files.writeString(directory.resolve("gradle.log"), result.output)
            assertTrue(result.output.contains("CODE_SOURCE net.msrandom.minecraftcodev.includes.IncludedJarInfo"))
            return result
        } catch (failure: UnexpectedBuildFailure) {
            Files.writeString(directory.resolve("gradle.log"), failure.buildResult.output)
            throw failure
        }
    }

    @Test
    fun duplicateAndDownstreamRequestsSurviveLaterDefaultRequestsAndCapabilityOrder() {
        val explicit = selector("chosen:extra")
        val ordinary = selector()
        val capability = capability("chosen", "extra")
        val defaults = capability("ordinary", "producer")
        for (capabilities in listOf(listOf(defaults, capability), listOf(capability, defaults))) {
            val variant = variant("runtime", capabilities)
            val artifact = artifact(variant)
            val downstream = edge(explicit, variant)
            val bridge = edge(ordinary, variant("bridge", emptyList()), listOf(downstream))
            for (requests in listOf(listOf(explicit, ordinary, explicit), listOf(explicit, explicit, ordinary))) {
                val info = extract(listOf(bridge) + requests.map { edge(it, variant) }, artifact).single()
                assertIdentity(info, "chosen", "extra")
                assertEquals(artifact.file, info.file.get().asFile)
            }
        }
    }

    @Test
    fun differentVariantsOfOneProjectKeepSeparateIdentities() {
        val owner = projectId("producer")
        val a = variant("variant-a", listOf(capability("chosen", "a")))
        val b = variant("variant-b", listOf(capability("chosen", "b")))
        val result = extract(
            listOf(edge(selector("chosen:a"), a), edge(selector("chosen:b"), b), edge(selector(), a)),
            artifact(a, owner), artifact(b, owner),
        )
        assertEquals(listOf("a", "b"), result.map { it.moduleName.get() })
    }

    @Test
    fun artifactVariantProjectionPreservesAttributesAndSeparatesSameProjectVariants() {
        val owner = projectId("producer")
        val capabilities = listOf(capability("ordinary", "producer"), capability("chosen", "a"), capability("chosen", "b"))
        val flavor = Attribute.of("identity.flavor", String::class.java)
        val artifactType = Attribute.of("artifactType", String::class.java)
        fun attributes(value: String, artifact: Boolean = false): AttributeContainer =
            project.configurations.detachedConfiguration().attributes.also {
                it.attribute(flavor, value)
                if (artifact) it.attribute(artifactType, "jar")
            }
        val a = variant("a", capabilities, owner, attributes("a"))
        val b = variant("b", capabilities, owner, attributes("b"))
        val artifactA = artifact(variant("configuration ':producer:a'", capabilities.reversed(), owner, attributes("a", true)), owner)
        val artifactB = artifact(variant("configuration ':producer:b'", capabilities, owner, attributes("b", true)), owner)
        val edges = listOf(edge(selector("chosen:a"), a), edge(selector("chosen:b"), b), edge(selector(), a))
        assertEquals(listOf("a", "b"), extract(edges, artifactA, artifactB).map { it.moduleName.get() })

        val indistinguishable = variant("other-a", capabilities, owner, attributes("a"))
        val failure = assertThrows(GradleException::class.java) {
            extract(edges + edge(selector("chosen:b"), indistinguishable), artifactA)
        }
        assertDiagnostic(failure, artifactA, "chosen:a", "chosen:b")
        assertTrue(failure.message!!.contains("Cannot uniquely associate"))
        val unmatched = artifact(variant("unknown projection", capabilities, owner, attributes("unknown", true)), owner)
        val unmatchedFailure = assertThrows(GradleException::class.java) { extract(edges, unmatched) }
        assertDiagnostic(unmatchedFailure, unmatched, "chosen:a", "chosen:b")
    }

    @Test
    fun mismatchedCompleteRequestsFailWithArtifactVariantAndRequestedCoordinates() {
        for (request in listOf("wrong:extra", "chosen:missing")) {
            val variant = variant("mismatch-runtime", listOf(capability("chosen", "extra"), capability("ordinary", "producer")))
            val artifact = artifact(variant)
            val failure = assertThrows(GradleException::class.java) { extract(listOf(edge(selector(request), variant)), artifact) }
            assertTrue(failure.message!!.contains("No matching capability identity"))
            assertDiagnostic(failure, artifact, request)
            assertTrue(warnings.isEmpty())
        }
    }

    @Test
    fun distinctRequestsIncludingDownstreamAreAmbiguousRegardlessOfOrder() {
        val a = selector("chosen:a")
        val b = selector("chosen:b")
        val variant = variant("ambiguous-runtime", listOf(capability("chosen", "a"), capability("chosen", "b")))
        val artifact = artifact(variant)
        for ((first, second) in listOf(a to b, b to a)) {
            val bridge = edge(selector(), variant("bridge", emptyList()), listOf(edge(first, variant)))
            val failure = assertThrows(GradleException::class.java) {
                extract(listOf(bridge, edge(second, variant)), artifact)
            }
            assertTrue(failure.message!!.contains("Ambiguous capability identities"))
            assertDiagnostic(failure, artifact, "chosen:a", "chosen:b")
            assertTrue(warnings.isEmpty())
        }
    }

    @Test
    fun featureOnlyRealSelectorDoesNotPromoteSyntheticLegacyCoordinates() {
        val feature = selector(feature = "extra")
        assertEquals(listOf("ordinary:library-extra"), feature.requestedCapabilities.map { "${it.group}:${it.name}" })
        assertEquals(1, feature.capabilitySelectors.size)
        val variant = variant("feature-runtime", listOf(capability("ordinary", "library-extra"), capability("ordinary", "library")))
        val info = extract(listOf(edge(feature, variant)), artifact(variant, moduleId())).single()
        assertIdentity(info, "ordinary", "library")
    }

    @Test
    fun realFeatureAndCompleteRequestsKeepCompleteNonmatchesAndDeduplicateVersions() {
        val variant = variant("mixed-runtime", listOf(capability("ordinary", "library-extra"), capability("ordinary", "library")))
        val complete = selector("ordinary:library-extra", feature = "extra")
        assertIdentity(extract(listOf(edge(complete, variant)), artifact(variant, moduleId())).single(), "ordinary", "library-extra")
        val mismatch = selector("missing:identity", feature = "extra")
        val failure = assertThrows(GradleException::class.java) { extract(listOf(edge(mismatch, variant)), artifact(variant)) }
        assertDiagnostic(failure, artifact(variant), "missing:identity")
        val duplicate = selector("ordinary:library-extra:9", "ordinary:library-extra:10")
        assertIdentity(extract(listOf(edge(duplicate, variant)), artifact(variant)).single(), "ordinary", "library-extra")
    }

    @Test
    fun ordinaryModulePrefersExactComponentCoordinatesIncludingVersion() {
        val variant = variant("module-runtime", listOf(
            capability("ordinary", "library", "other"), capability("other", "library"), capability("ordinary", "library"),
        ))
        val info = extract(listOf(edge(selector(), variant)), artifact(variant, moduleId())).single()
        assertIdentity(info, "ordinary", "library")
        assertEquals("1.0", info.artifactVersion.get())
    }

    @Test
    fun ordinaryProjectPrefersProjectNameAndFallbackKeepsFirstCapabilityOrder() {
        val named = variant("named-runtime", listOf(capability("first", "extra"), capability("ordinary", "producer")))
        assertIdentity(extract(emptyList(), artifact(named)).single(), "ordinary", "producer")
        for (capabilities in listOf(
            listOf(capability("one", "a"), capability("two", "b")),
            listOf(capability("two", "b"), capability("one", "a")),
        )) {
            val variant = variant("fallback-runtime", capabilities)
            val info = extract(listOf(edge(selector(), variant)), artifact(variant)).single()
            assertIdentity(info, capabilities.first().group, capabilities.first().name)
        }
    }

    @Test
    fun absentCapabilitiesWarnAndSkipButExplicitRequestFails() {
        val variant = variant("empty-runtime", emptyList())
        val artifact = artifact(variant)
        assertTrue(extract(emptyList(), artifact).isEmpty())
        assertEquals(listOf("Skipping included file ${artifact.file} as its coordinates could not be determined"), warnings)
        val failure = assertThrows(GradleException::class.java) { extract(listOf(edge(selector("chosen:extra"), variant)), artifact) }
        assertDiagnostic(failure, artifact, "chosen:extra")
        assertEquals(1, warnings.size)
    }

    @Test
    fun artifactVersionFallbackIsCapabilityThenComponentThenSelectorThenZero() {
        val selected = selector(version = "selector-version")
        for ((capabilityVersion, owner, request, expected) in listOf(
            VersionCase("capability-version", moduleId(version = "component-version"), selected, "capability-version"),
            VersionCase(null, moduleId(version = "component-version"), selected, "component-version"),
            VersionCase(null, projectId("producer"), selected, "selector-version"),
            VersionCase(null, projectId("producer"), null, "0.0.0"),
        )) {
            val variant = variant("version-runtime", listOf(capability("ordinary", "producer", capabilityVersion)))
            val info = extract(request?.let { listOf(edge(it, variant)) }.orEmpty(), artifact(variant, owner)).single()
            assertEquals(expected, info.artifactVersion.get())
            if (request == null) assertEquals("[0.0.0,)", info.versionRange.get())
        }
    }

    @Test
    fun lastSelectorStillDeterminesVersionRangeStrictThenRequiredThenPreferredThenDefault() {
        val explicit = selector("chosen:extra", version = "first-range")
        val variant = variant("range-runtime", listOf(capability("chosen", "extra", "artifact-version")))
        val cases = listOf(
            selector(version = "", strict = "strict", preferred = "preferred") to "strict",
            selector(version = "required", preferred = "preferred") to "required",
            selector(version = "", preferred = "preferred") to "preferred",
            selector(version = "") to "[artifact-version,)",
        )
        for ((last, expected) in cases) {
            val artifact = artifact(variant)
            val forward = extract(listOf(edge(explicit, variant), edge(last, variant)), artifact).single()
            assertIdentity(forward, "chosen", "extra")
            assertEquals(expected, forward.versionRange.get())
            val reversed = extract(listOf(edge(last, variant), edge(explicit, variant)), artifact).single()
            assertIdentity(reversed, "chosen", "extra")
            assertEquals("first-range", reversed.versionRange.get())
        }
        val projectSelector = stub<ComponentSelector>("getRequestedCapabilities" to emptyList<Capability>())
        val info = extract(listOf(edge(explicit, variant), edge(projectSelector, variant)), artifact(variant)).single()
        assertEquals("[artifact-version,)", info.versionRange.get())
    }

    @Test
    fun unresolvedFailurePropagatesUnchangedIncludingDownstream() {
        val failure = GradleException("original unresolved failure")
        val unresolved = stub<UnresolvedDependencyResult>("getFailure" to failure)
        val thrown = assertThrows(GradleException::class.java) {
            extract(listOf(edge(selector(), variant("bridge", emptyList()), listOf(unresolved))))
        }
        assertSame(failure, thrown)
    }

    @Test
    fun resolutionSourcesGatherRequestsBeforeVariantArtifactDeduplication() {
        val owner = projectId("producer")
        val caps = listOf(capability("ordinary", "producer"), capability("chosen", "a"), capability("chosen", "b"))
        val flavor = Attribute.of("identity.flavor", String::class.java)
        val extra = Attribute.of("identity.extra", String::class.java)
        val artifactType = Attribute.of("artifactType", String::class.java)
        fun attributes(artifact: Boolean = false, additional: Boolean = false) =
            project.configurations.detachedConfiguration().attributes.also {
                it.attribute(flavor, "a")
                if (artifact) it.attribute(artifactType, "jar")
                if (additional) it.attribute(extra, "value")
            }
        val origin = IncludeTargetOrigin("build-root", ":producer", "demo:a", "chosen", "a")
        for (capabilities in listOf(caps, caps.reversed())) {
            val ordinaryVariant = variant("runtime", capabilities, owner, attributes())
            val targetVariant = variant("runtime", capabilities.reversed(), owner, attributes())
            val first = artifact(variant("artifact projection", capabilities, owner, attributes(true)), owner)
            val duplicate = artifact(variant("artifact projection", capabilities.reversed(), owner, attributes(true)), owner, id = first.id)
            val classifier = artifact(first.variant, owner, fixtures.resolve("classifier.jar").toFile())
            val ordinary = source(listOf(edge(selector(), ordinaryVariant)), listOf(first))
            val target = source(listOf(edge(projectSelector("chosen:a"), targetVariant)), listOf(duplicate, classifier), origin)
            val requestsOnly = source(listOf(edge(projectSelector("chosen:a"), targetVariant)), emptyList(), origin)
            for (sources in listOf(listOf(ordinary, target, requestsOnly), listOf(requestsOnly, target, ordinary))) {
                val result = gather(sources)
                assertEquals(2, result.size)
                result.forEach { assertIdentity(it, "chosen", "a") }
                assertEquals(setOf(first.file, classifier.file), result.map { it.file.get().asFile }.toSet())
            }
            for (request in listOf("wrong:a", "chosen:missing", "chosen:b")) {
                val conflicting = source(listOf(edge(projectSelector(request), targetVariant)), emptyList(), origin)
                val failure = assertThrows(GradleException::class.java) { gather(listOf(ordinary, target, conflicting)) }
                assertDiagnostic(failure, first, "chosen:a", request)
                if (request != "chosen:b") {
                    val nonmatch = assertThrows(GradleException::class.java) { gather(listOf(ordinary, conflicting)) }
                    assertTrue(nonmatch.message!!.contains("No matching capability identity"))
                    assertDiagnostic(nonmatch, first, request)
                }
            }
            val featureOnly = source(listOf(edge(selector(feature = "extra"), ordinaryVariant)), listOf(first))
            assertIdentity(gather(listOf(featureOnly, source(listOf(edge(projectSelector(), targetVariant)), listOf(duplicate), origin))).single(), "ordinary", "producer")

            // Equal files/coordinates are not evidence that two original targets are the same.
            val collision = origin.copy(targetName = "demo-a")
            val secondTarget = source(listOf(edge(projectSelector("chosen:a"), targetVariant)), listOf(duplicate), collision)
            assertEquals(2, gather(listOf(target, secondTarget)).count { it.file.get().asFile == first.file })
            val ambiguous = assertThrows(GradleException::class.java) { gather(listOf(target, secondTarget, ordinary)) }
            assertTrue(ambiguous.message!!.contains("Cannot uniquely associate"))
            assertTrue(ambiguous.message!!.contains("demo:a"))
            assertTrue(ambiguous.message!!.contains("demo-a"))

            val fuller = variant("runtime", capabilities, owner, attributes(additional = true))
            val fullerArtifact = artifact(fuller, owner, id = first.id)
            assertEquals(2, gather(listOf(target, source(listOf(edge(projectSelector("chosen:a"), fuller)), listOf(fullerArtifact), origin))).count { it.file.get().asFile == first.file })
            val differentlyNamed = variant("another-runtime", capabilities, owner, attributes())
            assertEquals(2, gather(listOf(target, source(listOf(edge(projectSelector("chosen:a"), differentlyNamed)), listOf(artifact(differentlyNamed, owner)), origin))).count { it.file.get().asFile == first.file })

            val secondRealVariant = variant("runtime", capabilities, owner, attributes())
            val twoRealVariants = source(
                listOf(edge(projectSelector("chosen:a"), ordinaryVariant), edge(projectSelector("chosen:a"), secondRealVariant)),
                listOf(artifact(ordinaryVariant, owner), artifact(secondRealVariant, owner)), origin,
            )
            assertThrows(GradleException::class.java) { gather(listOf(twoRealVariants, requestsOnly)) }
            val projected = source(twoRealVariants.rootComponent.dependencies.toList(), listOf(first), origin)
            assertThrows(GradleException::class.java) { gather(listOf(projected)) }
        }
        val failure = GradleException("cross-source unresolved")
        assertSame(failure, assertThrows(GradleException::class.java) {
            gather(listOf(source(listOf(stub<UnresolvedDependencyResult>("getFailure" to failure)), emptyList(), origin)))
        })
        assertThrows(IllegalArgumentException::class.java) { gather(listOf(source(emptyList(), emptyList()), source(emptyList(), emptyList()))) }
        val empty = variant("no-capabilities", emptyList())
        assertTrue(gather(listOf(source(emptyList(), listOf(artifact(empty))))).isEmpty())
        assertEquals(1, warnings.size)
        assertThrows(GradleException::class.java) { gather(listOf(source(listOf(edge(projectSelector("chosen:a"), empty)), listOf(artifact(empty)), origin))) }
    }

    @Test
    fun resolutionSourcesPreferOrdinaryEffectiveLastSelectorForVersions() {
        val origin = IncludeTargetOrigin("build-root", ":producer", "extra", "chosen", "extra")
        val projectRequest = projectSelector("chosen:extra")
        val earlierModule = selector(version = "earlier")
        val cases = listOf(
            selector(version = "", strict = "strict", preferred = "preferred") to "strict",
            selector(version = "required", preferred = "preferred") to "required",
            selector(version = "", preferred = "preferred") to "preferred",
            selector(version = "") to "[artifact-version,)",
            projectSelector() to "[artifact-version,)",
        )
        val owner = projectId("producer")
        for ((last, expected) in cases) {
            val a = variant("runtime", listOf(capability("chosen", "extra", "artifact-version")), owner)
            val b = variant("runtime", a.capabilities, owner)
            val ordinary = source(listOf(edge(earlierModule, a), edge(last, a)), emptyList())
            val target = source(listOf(edge(projectRequest, b)), listOf(artifact(b, owner)), origin)
            for (sources in listOf(listOf(ordinary, target), listOf(target, ordinary))) {
                val info = gather(sources).single()
                assertIdentity(info, "chosen", "extra")
                assertEquals("artifact-version", info.artifactVersion.get())
                assertEquals(expected, info.versionRange.get())
            }
            assertEquals("[artifact-version,)", gather(listOf(target)).single().versionRange.get())
        }
        for ((capabilityVersion, component, request, expected) in listOf(
            VersionCase("capability-version", moduleId("component-version"), selector(version = "selector-version"), "capability-version"),
            VersionCase(null, moduleId("component-version"), selector(version = "selector-version"), "component-version"),
            VersionCase(null, owner, selector(version = "selector-version"), "selector-version"),
            VersionCase(null, owner, projectSelector(), "0.0.0"),
            VersionCase(null, owner, null, "0.0.0"),
        )) {
            val a = variant("runtime", listOf(capability("chosen", "extra", capabilityVersion)), component)
            val b = variant("runtime", a.capabilities, component)
            val ordinary = source(listOf(edge(earlierModule, a), edge(request ?: projectSelector(), a)), emptyList())
            val target = source(listOf(edge(projectRequest, b)), listOf(artifact(b, component)), origin)
            val info = gather(if (request == null) listOf(target) else listOf(target, ordinary)).single()
            assertIdentity(info, "chosen", "extra")
            assertEquals(expected, info.artifactVersion.get())
            if (request == null || request !is org.gradle.api.artifacts.component.ModuleComponentSelector) {
                assertEquals("[$expected,)", info.versionRange.get())
            }
        }
    }

    private fun source(
        edges: List<DependencyResult>,
        artifacts: List<ResolvedArtifactResult>,
        origin: IncludeTargetOrigin? = null,
    ) = ResolvedIncludeSource(stub<ResolvedComponentResult>("getDependencies" to edges.toSet()), artifacts.toSet(), origin)

    private fun gather(sources: List<ResolvedIncludeSource>) = IncludedJarInfo.fromResolutionSources(project.objects, sources, logger)

    private fun projectSelector(vararg requested: String): ComponentSelector {
        if (project.findProject(":producer") == null) ProjectBuilder.builder().withName("producer").withParent(project).build()
        val dependency = project.dependencies.project(mapOf("path" to ":producer")) as org.gradle.api.artifacts.ProjectDependency
        dependency.capabilities { requested.forEach { requireCapability(it) } }
        val configuration = project.configurations.detachedConfiguration(dependency)
        configuration.isTransitive = false
        return configuration.incoming.resolutionResult.rootComponent.get().dependencies.single().requested
    }

    private fun selector(
        vararg requested: String,
        feature: String? = null,
        version: String = "1.0",
        strict: String? = null,
        preferred: String? = null,
    ): ComponentSelector {
        val dependency = project.dependencies.create("ordinary:library") as ExternalModuleDependency
        dependency.version {
            require(version)
            if (strict != null) strictly(strict)
            if (preferred != null) prefer(preferred)
        }
        dependency.capabilities {
            requested.forEach { requireCapability(it) }
            if (feature != null) requireFeature(feature)
        }
        val configuration = project.configurations.detachedConfiguration(dependency)
        configuration.isTransitive = false
        return configuration.incoming.resolutionResult.rootComponent.get().dependencies.single().requested
    }

    private fun extract(edges: List<DependencyResult>, vararg artifacts: ResolvedArtifactResult): List<IncludedJarInfo> =
        IncludedJarInfo.fromResolutionResults(
            project.objects, stub<ResolvedComponentResult>("getDependencies" to edges.toSet()), artifacts.toSet(), logger,
        )

    private fun edge(
        selector: ComponentSelector,
        variant: ResolvedVariantResult,
        downstream: List<DependencyResult> = emptyList(),
    ): ResolvedDependencyResult = stub(
        "getRequested" to selector,
        "getResolvedVariant" to variant,
        "getSelected" to stub<ResolvedComponentResult>("getDependenciesForVariant" to downstream),
    )

    private fun variant(
        name: String,
        capabilities: List<Capability>,
        owner: ComponentIdentifier = projectId("producer"),
        attributes: AttributeContainer = project.configurations.detachedConfiguration().attributes,
    ): ResolvedVariantResult = stub(
        "getDisplayName" to name, "getCapabilities" to capabilities, "getOwner" to owner, "getAttributes" to attributes,
    )

    private fun artifact(
        variant: ResolvedVariantResult,
        owner: ComponentIdentifier = projectId("producer"),
        file: File = fixtures.resolve("included.jar").toFile(),
        id: ComponentArtifactIdentifier = stub<ComponentArtifactIdentifier>("getComponentIdentifier" to owner),
    ): ResolvedArtifactResult = stub("getVariant" to variant, "getFile" to file, "getId" to id)

    private fun capability(group: String, name: String, version: String? = "1.0"): Capability =
        stub("getGroup" to group, "getName" to name, "getVersion" to version)

    private fun projectId(name: String): ProjectComponentIdentifier = stub("getProjectName" to name)

    private fun moduleId(version: String = "1.0"): ModuleComponentIdentifier =
        stub("getGroup" to "ordinary", "getModule" to "library", "getVersion" to version)

    private fun assertIdentity(info: IncludedJarInfo, group: String, name: String) {
        assertEquals(group, info.group.get())
        assertEquals(name, info.moduleName.get())
    }

    private fun assertDiagnostic(failure: GradleException, artifact: ResolvedArtifactResult, vararg requests: String) {
        val message = checkNotNull(failure.message)
        assertTrue(message.contains(artifact.file.toString()), message)
        assertTrue(message.contains(artifact.variant.displayName), message)
        requests.forEach { assertTrue(message.contains(it), message) }
    }

    private data class VersionCase(val version: String?, val owner: ComponentIdentifier, val request: ComponentSelector?, val expected: String)

    // Only resolution result shapes are doubled; requested selectors above come from Gradle itself.
    private inline fun <reified T> stub(
        vararg members: Pair<String, Any?>,
        crossinline call: (String, Array<out Any?>) -> Any? = { name, _ -> error("Unexpected call $name") },
    ): T {
        val values = members.toMap()
        return Proxy.newProxyInstance(T::class.java.classLoader, arrayOf(T::class.java)) { proxy, method, arguments ->
            when (method.name) {
                "hashCode" -> System.identityHashCode(proxy)
                "equals" -> proxy === arguments!![0]
                "toString" -> T::class.java.simpleName + values
                else -> if (values.containsKey(method.name)) values[method.name] else call(method.name, arguments.orEmpty())
            }
        } as T
    }
}
