plugins {
  // Support convention plugins written in Kotlin.
  // Convention plugins are build scripts in 'src/main'
  // that automatically become available as plugins in the main build.
  `kotlin-dsl`
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
    create("iris-base-plugin") {
      id = "com.hantasmate.iris.plugin.base"
      implementationClass = "com.hantasmate.iris.plugin.base.IrisBasePlugin"
    }

    create("iris-application-plugin") {
      id = "com.hantasmate.iris.plugin.application"
      implementationClass = "com.hantasmate.iris.plugin.application.IrisApplicationPlugin"
    }

    create("iris-library-plugin") {
      id = "com.hantasmate.iris.plugin.library"
      implementationClass = "com.hantasmate.iris.plugin.library.IrisLibraryPlugin"
    }
  }
}
