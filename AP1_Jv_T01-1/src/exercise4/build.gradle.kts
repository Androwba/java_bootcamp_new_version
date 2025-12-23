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
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(18))
}

tasks.test {
    useJUnitPlatform()
}

tasks.register<JavaExec>("run") {
    group = "application"
    description = "Calculates negative average number"

    mainClass.set("edu.school21.NegativeAverageCalculator")
    classpath = sourceSets["main"].runtimeClasspath
    standardInput = System.`in`
}
