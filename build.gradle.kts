import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    java
    kotlin("jvm") version "2.0.0"
    id("fabric-loom") version "1.7.1"
    id("net.kyori.blossom") version "1.3.2"
}

repositories {
    maven("https://maven.teamresourceful.com/repository/maven-public/")
    maven("https://pkgs.dev.azure.com/djtheredstoner/DevAuth/_packaging/public/maven/v1")
    maven("https://repo.hypixel.net/repository/Hypixel/")
    maven("https://api.modrinth.com/maven")
}

dependencies {
    minecraft("com.mojang:minecraft:1.21.1")
    mappings(loom.officialMojangMappings())
    modImplementation(libs.fabricLoader)
    modImplementation(libs.fabricApi)
    modImplementation(libs.fabricKt)

    modImplementation(libs.hypixelapi)
    modImplementation(libs.skyblockapi)
    modImplementation(libs.resourcefulconfig)
    modImplementation(libs.resourcefulconfigkt)
    modImplementation(libs.resourcefullib)
    modImplementation(libs.olympus)

    include(libs.hypixelapi)
    include(libs.skyblockapi)
    include(libs.resourcefulconfig)
    include(libs.resourcefulconfigkt)
    include(libs.resourcefullib)
    include(libs.olympus)

    modRuntimeOnly(libs.devauth)
}

loom {
    runs {
        getByName("client") {
            property("devauth.configDir", rootProject.file(".devauth").absolutePath)
        }
    }
}

blossom {
    replaceToken("@MOD_VERSION@", project.version)
}

tasks {
    processResources {
        inputs.property("version", project.version)
        filesMatching("fabric.mod.json") {
            expand(getProperties())
            expand(mutableMapOf("version" to project.version))
        }
    }

    jar {
        from("LICENSE")
    }

    compileKotlin {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_21
        }
    }

}

java {
    withSourcesJar()
}

idea {
    module {
        excludeDirs.add(file("run"))
    }
}
