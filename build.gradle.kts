import org.gradle.api.tasks.testing.Test
import org.jlleitschuh.gradle.ktlint.KtlintExtension

plugins {
    java
    `embedded-kotlin`
    `kotlin-dsl` apply false
    kotlin("plugin.serialization") version embeddedKotlinVersion apply false
    id("org.jlleitschuh.gradle.ktlint") version "12.1.0" apply false
    id("org.jetbrains.intellij.platform") version "2.6.0" apply false
    `java-gradle-plugin`
    `maven-publish`
}

// Keep the cross-project publisher and its non-cacheable lifecycle local to CI invocations.
if (providers.gradleProperty("ciMavenBase").isPresent || providers.gradleProperty("ciMavenOutput").isPresent ||
    gradle.startParameter.taskNames.any { it.substringAfterLast(':') == "prepareCiMavenRepository" || it.endsWith("CiMavenRepository") }
) {
    // The JDK 8 doclet can emit these siblings in either order. Stabilize CI docs before packaging.
    project(":minecraft-codev-core:side-annotations").tasks.withType<Javadoc>().matching { it.name == "javadoc" }.configureEach {
        doLast {
            val row = Regex("""(?m)^<li type="circle">[^\r\n]*?<span class="typeNameLink">(UnsafeForClient|UnsafeForCommon)</span>[^\r\n]*</li>$""")
            for (page in listOf("overview-tree.html", "net/msrandom/minecraftcodev/annotations/package-tree.html")) {
                val file = checkNotNull(destinationDir).resolve(page)
                val text = file.readText()
                val siblings = row.findAll(text).toList()
                check(siblings.size == 2 && siblings.map { it.groupValues[1] }.distinct().size == 2) { "Unexpected annotation hierarchy in $page" }
                val (first, second) = siblings
                val newline = text.substring(first.range.last + 1, second.range.first)
                check(newline == "\n" || newline == "\r\n") { "Expected adjacent annotations in $page" }
                if (first.groupValues[1] > second.groupValues[1]) {
                    file.writeText(text.replaceRange(first.range.first..second.range.last, second.value + newline + first.value))
                }
            }
        }
    }

    apply(from = "gradle/ci-maven.gradle.kts")
}

tasks.test {
    dependsOn(":minecraft-codev-mixins:test", ":minecraft-codev-fabric:test", ":minecraft-codev-forge:test")
}

subprojects {
    apply(plugin = "java")
}

childProjects.values.forEach { project ->
    with(project) {
        apply(plugin = "org.jetbrains.kotlin.jvm")
        apply(plugin = "org.jetbrains.kotlin.plugin.serialization")
        apply(plugin = "org.jlleitschuh.gradle.ktlint")
        apply(plugin = "maven-publish")

        java {
            toolchain.languageVersion.set(JavaLanguageVersion.of(11))
            withSourcesJar()
            withJavadocJar()
        }

        configure<KtlintExtension> {
            additionalEditorconfig.put("ktlint_code_style", "intellij_idea")
        }

        dependencies {
            implementation(kotlin("stdlib"))

            testImplementation(gradleTestKit())
            testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-api", version = "5.9.0-M1")
            testRuntimeOnly(group = "org.junit.jupiter", name = "junit-jupiter-engine")
        }

        publishing {
            repositories {
                mavenLocal()

                maven("https://maven.msrandom.net/repository/cloche/") {
                    credentials {
                        val mavenUsername: String? by project
                        val mavenPassword: String? by project

                        username = mavenUsername
                        password = mavenPassword
                    }
                }
            }
        }

        tasks.withType<Test>().configureEach {
            systemProperty("org.gradle.testkit.dir", gradle.gradleUserHomeDir.absolutePath)

            maxHeapSize = "3G"

            useJUnitPlatform()

            testLogging {
                error {
                    showStandardStreams = true
                }
            }
        }
    }
}
