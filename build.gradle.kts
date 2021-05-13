plugins {
    id ("org.jetbrains.kotlin.jvm") version "1.4.32"
    `maven-publish`
    `java-library`
    signing
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
}

group = "io.github.zhangxuchang"
version = "1.0.3"

java {
    withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("alphaUtils") {
            artifactId = "alphaUtils"
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
                        id.set("zhangxuchang")
                        name.set("ZHANG XUCHANG")
                        email.set("zhangxuchang@oasgames.com")
                    }
                }
                scm {
                    connection.set("scm:git:git@github.com:zhangxuchang/alpha-utils.git")
                    developerConnection.set("scm:git:git@github.com:zhangxuchang/alpha-utils.git")
                    url.set("https://github.com/zhangxuchang/alpha-utils")
                }
            }
        }
    }

    repositories {
        maven {
            name = "alphaUtils"
            url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            //url = uri(layout.buildDirectory.dir("repo"))
        }
    }
}

signing {
    sign(publishing.publications["alphaUtils"])
}

tasks.javadoc {
    if (JavaVersion.current().isJava9Compatible) {
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }
}