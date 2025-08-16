plugins {
    `java-library`
    `maven-publish`
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(8))
    withSourcesJar()
    withJavadocJar()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }

    repositories {
        val mavenUsername: String? by project
        val mavenPassword: String? by project

        maven("https://maven.msrandom.net/repository/root/") {
            name = "msrandomRoot"

            credentials {
                username = mavenUsername
                password = mavenPassword
            }
        }

        maven("https://maven.msrandom.net/repository/cloche/") {
            name = "msrandomCloche"

            credentials {
                username = mavenUsername
                password = mavenPassword
            }
        }
    }
}
