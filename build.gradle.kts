buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(ClassPaths.gradle)
        classpath(ClassPaths.kotlinGradlePlugin)
        classpath(Dependencies.hiltGradlePlugin)
        classpath(Dependencies.navigationSafeArgs)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}