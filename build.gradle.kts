plugins {
    id ("org.jetbrains.kotlin.jvm") version "1.4.32"
    `maven-publish`
    signing
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
}

group = "org.xuchang"
version = "1.0.0"

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = "utils"
            from(components["java"])
            pom {
                name.set("Alpha Utils Library")
                description.set("A Utils for server develop")
                url.set("https://github.com/zhangxuchang/alpha-utils")
                properties.set(mapOf(
                    "myProp" to "value",
                    "prop.with.dots" to "anotherValue"
                ))
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("xuchangzhang")
                        name.set("ZHANG XUCHANG")
                        email.set("zhangxuchang@oasgames.com")
                    }
                }
                scm {
                    connection.set("scm:git:git@github.com:zhangxuchang/alpha-utils.git")
                    developerConnection.set("scm:git:ssh://example.com/my-library.git")
                    url.set("https://github.com/zhangxuchang/alpha-utils")
                }
            }
        }
    }

    repositories {
        maven {
            name = "alphaUtils"
            url = uri(layout.buildDirectory.dir("repo"))
        }
    }
}

signing {
    sign(publishing.publications["maven"])
}