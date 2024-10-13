rootProject.name = "Custom Scoreboard"

pluginManagement {
    repositories {
        maven("https://maven.fabricmc.net/")
        maven("https://maven.teamresourceful.com/repository/maven-private/")
        gradlePluginPortal()
        mavenLocal()
    }
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs")
    }
}
