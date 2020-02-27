
buildscript {


    repositories {
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
        "compile"("org.springframework:spring-web:5.0.2.RELEASE")
    }
}
plugins {
    `java-library`
}
repositories {
    mavenCentral()
    mavenLocal()
}
