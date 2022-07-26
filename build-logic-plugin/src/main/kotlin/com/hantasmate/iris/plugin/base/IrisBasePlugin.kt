/*
 * copyright(c) 2018-2022 tabuyos all right reserved.
 */
package com.hantasmate.iris.plugin.base

import Maven
import com.hantasmate.iris.plugin.IrisPlugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPlugin
import org.gradle.kotlin.dsl.*
import java.io.File
import java.net.URI

/**
 * IrisBasePlugin
 *
 * @author tabuyos
 * @since 2022/7/25
 */
abstract class IrisBasePlugin : IrisPlugin() {
  override fun apply(project: Project) {
    project.pluginManager.apply(JavaPlugin::class)


    println(project.rootProject.name)
    val extension = project.extensions.create("irisBase", IrisBaseExtension::class)
    project.tasks.register<IrisBaseTask>("hello") {
      greeting.set("Hello Iris.")
    }
    handle(project)
  }

  private fun handle(project: Project) {
    Maven.repositories.forEach { repo ->
      project.repositories.maven(URI.create(repo.url)) {
        name = repo.name
      }
    }

    project.repositories.mavenCentral()
    project.repositories.google()
    project.repositories.mavenLocal()
  }

  private fun deleteDirectory(file: File): Boolean {
    if (file.isFile) {
      return file.delete()
    } else {
      val childFiles = file.listFiles() ?: return file.delete()
      childFiles.forEach {
        deleteDirectory(it)
      }
    }
    return file.delete()
  }
}
