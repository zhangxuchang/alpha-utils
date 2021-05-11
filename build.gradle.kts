plugins {
    id ("org.jetbrains.kotlin.jvm") version "1.4.32"
    `maven-publish`
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "org.xuchang"
            artifactId = "utils"
            version = "1.0.0"
            from(components["java"])
        }
    }

    repositories {
        maven {
            name = "utils"
            url = uri(layout.buildDirectory.dir("repo"))
        }
    }
}