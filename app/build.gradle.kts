plugins {
  id("com.hantasmate.iris.gradle.plugin.application")
}

dependencies {
  implementation(Google.guava)
  implementation(project(":library"))
}
