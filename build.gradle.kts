plugins {
    id ("org.jetbrains.kotlin.jvm") version "1.4.32"
}

group "org.xuchang"
version "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
}
