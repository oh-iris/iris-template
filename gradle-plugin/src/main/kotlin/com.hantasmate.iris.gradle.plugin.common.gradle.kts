import org.gradle.kotlin.dsl.*
import java.net.URI

/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
  // Apply the java Plugin to add support for Java.
  java
  idea
}

Maven.repositories.forEach { repo ->
  project.repositories.maven(URI.create(repo.url)) {
    name = repo.name
  }
}

repositories {
  mavenCentral()
  google()
  mavenLocal()
}

// dependencies {
//   constraints {
//     // Define dependency versions as constraints
//     implementation("org.apache.commons:commons-text:1.9")
//   }
//
//   // Use JUnit Jupiter for testing.
//   testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
// }

tasks.named<Test>("test") {
  // Use JUnit Platform for unit tests.
  useJUnitPlatform()
}