plugins {
    id("java")
}

group = "edu.school21"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(18))
}

tasks.register<JavaExec>("run") {
    group = "application"
    description = "NameFinder"

    mainClass.set("edu.school21.NameFinder")
    classpath = sourceSets["main"].runtimeClasspath
    standardInput = System.`in`
}