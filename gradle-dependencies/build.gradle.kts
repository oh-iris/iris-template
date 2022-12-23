description = """
  复合构建模块
  主要负责依赖管理, 后期如果需要对平台进行依赖管理发布, 可直接修改该模块即可
""".trimIndent()

group = "com.hantasmate.iris"

plugins {
  `kotlin-dsl`
}

repositories {
  gradlePluginPortal()
}
