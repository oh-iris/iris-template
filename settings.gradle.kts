enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
enableFeaturePreview("VERSION_CATALOGS")

// 复合构建, 用于统一依赖管理, 版本更新
includeBuild("gradle-dependencies")
includeBuild("gradle-plugin")

rootProject.name = "iris-template"

include("app", "base", "library")
