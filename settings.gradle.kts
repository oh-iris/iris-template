enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
enableFeaturePreview("VERSION_CATALOGS")

// explicitly specify composite build project by include
includeBuild("build-logic-plugin")
//includeBuild("build-logic")

rootProject.name = "iris-template"

 include("app", "list", "utilities", "hello")
