plugins {
  id("com.hantasmate.iris.plugin.application")
}

dependencies {
  implementation(Google.guava)
  implementation(project(":library"))
}

application {
  // Define the main class for the application.
  mainClass.set("ktapp.app.App")
}
