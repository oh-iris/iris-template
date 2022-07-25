plugins {
  // Support convention plugins written in Kotlin.
  // Convention plugins are build scripts in 'src/main'
  // that automatically become available as plugins in the main build.
  `kotlin-dsl`
  `java-gradle-plugin`
}

repositories {
  // Use the plugin portal to apply community plugins in convention plugins.
  gradlePluginPortal()
  mavenCentral()
}

dependencies {
  implementation(gradleApi())
}

gradlePlugin {
  plugins {
    create("irisDependencyVersionPlugin") {
      id = "com.iris.dependency"
      implementationClass = "com.iris.dependency.IrisDependencyVersionPlugin"
    }
  }
}
