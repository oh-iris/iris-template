description = """
  复合构建模块
  主要负责插件管理, 后期如果需要对平台进行插件管理发布, 可直接修改该模块即可
""".trimIndent()

group = "com.hantasmate.iris"

buildscript {
  dependencies {
    classpath("com.hantasmate.iris:gradle-dependencies")
  }
}

plugins {
  `kotlin-dsl`
}

repositories {
  gradlePluginPortal()
}

dependencies {
  implementation(Google.protobufGradlePlugin)
}
