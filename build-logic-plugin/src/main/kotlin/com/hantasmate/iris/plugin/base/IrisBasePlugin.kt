/*
 * copyright(c) 2018-2022 tabuyos all right reserved.
 */
package com.hantasmate.iris.plugin.base

import com.hantasmate.iris.plugin.IrisPlugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPlugin
import org.gradle.kotlin.dsl.buildscript
import org.gradle.kotlin.dsl.plugins
import java.net.URI

/**
 * IrisBasePlugin
 *
 * @author tabuyos
 * @since 2022/7/25
 */
class IrisBasePlugin : IrisPlugin {
  override fun apply(target: Project) {
    target.pluginManager.apply(JavaPlugin::class.java)
    val extension = target.extensions.create("irisBase", IrisBaseExtension::class.java)
    target.repositories.maven {
      url = URI.create(Maven.aliyunCentral.url)
      name = Maven.aliyunCentral.name
    }
    target.repositories.maven {
      url = URI.create(Maven.aliyunPublic.url)
      name = Maven.aliyunPublic.name
    }
    target.repositories.maven {
      url = URI.create(Maven.tencentPublic.url)
      name = Maven.tencentPublic.name
    }
    target.repositories.maven {
      url = URI.create(Maven.huaweiPublic.url)
      name = Maven.huaweiPublic.name
    }
    target.repositories.mavenCentral()
    target.repositories.google()
    target.repositories.mavenLocal()
  }
}
