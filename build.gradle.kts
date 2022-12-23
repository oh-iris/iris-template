buildscript {
  repositories {
    gradlePluginPortal()
  }
  dependencies {
    classpath("com.hantasmate.iris:gradle-dependencies")
    classpath("com.hantasmate.iris:gradle-plugin")
  }
}

group = "com.hantasmate.iris"
version = "0.1.0"

allprojects {
  apply(plugin = "com.hantasmate.iris.gradle.plugin.create")

  group = rootProject.group
  version = rootProject.version
}

subprojects {

  configurations {
    getByName("compileOnly") {
      extendsFrom(getByName("annotationProcessor"))
    }
  }

  extensions.configure<JavaPluginExtension> {
    sourceCompatibility = JavaVersion.toVersion(Version.java)
    targetCompatibility = JavaVersion.toVersion(Version.java)
  }

  tasks.withType<Test> {
    useJUnitPlatform()
  }

  configurations.all {
    // exclude(Exclude.springBootLogging)
  }

  tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    inputs.files(tasks.named("processResources"))
  }
}
