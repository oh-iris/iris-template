@file:Suppress("UnstableApiUsage", "UNUSED_VARIABLE")

plugins {
  // Apply the java Plugin to add support for Java.
  java
  `jvm-test-suite`
  checkstyle
}

java {
  sourceCompatibility = JavaVersion.VERSION_17
  targetCompatibility = JavaVersion.VERSION_17
  modularity.inferModulePath.set(true)
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(17))
  }
}

checkstyle {
  toolVersion = "17"
  maxWarnings = 0
  isIgnoreFailures = false
  isShowViolations = true
//    config = rootProject.resources.text.fromFile("config/checkstyle/checkstyle.xml")
}

tasks.withType<JavaCompile> {
  modularity.inferModulePath.set(true)
  options.isWarnings = true
  options.encoding = "UTF-8"
  options.release.set(17)
}

repositories {
  // Use Maven Central for resolving dependencies.
  mavenCentral()
}

dependencies {
  constraints {
    // Define dependency versions as constraints
    implementation("org.apache.commons:commons-text:1.9")
  }
}

testing {
  suites {
    // Configure the built-in test suite
    val test by getting(JvmTestSuite::class) {
      // Use JUnit Jupiter test framework
      useJUnitJupiter("5.7.2")
    }
    val integrationTest by registering(JvmTestSuite::class) {
//            dependencies {
//                implementation(project)
//            }

      targets {
        all {
          testTask.configure {
            shouldRunAfter(test)
          }
        }
      }
    }
  }
}

tasks.named("check") {
  dependsOn(testing.suites.named("integrationTest"))
}
