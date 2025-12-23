plugins {
    id("java")
}

group = "edu.school21"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(18))
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.register<JavaExec>("run") {
    group = "application"
    description = "Sorts the array"

    mainClass.set("edu.school21.SelectionSort")
    classpath = sourceSets["main"].runtimeClasspath
    standardInput = System.`in`
}
