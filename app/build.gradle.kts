plugins {
  id("com.hantasmate.iris.plugin.application")
}

dependencies {
//  implementation("org.apache.commons:commons-text")
  implementation(project(":utilities"))
}

application {
  // Define the main class for the application.
  mainClass.set("ktapp.app.App")
}
