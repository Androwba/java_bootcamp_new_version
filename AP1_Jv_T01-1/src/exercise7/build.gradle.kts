plugins {
    id("java")
    id("application")
}

group = "edu.school21"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(18))
}

application {
    mainClass.set("edu.school21.MinMaxFinder")
}

tasks.test {
    useJUnitPlatform()
}

tasks.clean {
    doLast {
        val resultFile = file("src/main/resources/result.txt")
        if (resultFile.exists()) {
            resultFile.delete()
            println("Deleted result.txt")
        }
    }
}
