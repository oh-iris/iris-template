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

  private val extensionName: String = "irisBase"

  override fun apply(project: Project) {
    handlePlugin(project)

    handleExtension(project)

    handleTask(project)

    handleRepository(project)
  }

  /**
   * Handle the default plugin for this project
   */
  private fun handlePlugin(project: Project) {
    project.pluginManager.apply(JavaPlugin::class)
  }

  /**
   * Handle the default extension for this project, making it configurable
   */
  private fun handleExtension(project: Project) {
    val extension = project.extensions.create(extensionName, IrisBaseExtension::class)
  }

  /**
   * Handle the default task for this project
   */
  private fun handleTask(project: Project) {
    project.tasks.register<IrisBaseTask>("welcome") {
      greeting.set("Welcome to Iris World.")
    }
    project.tasks.register<IrisBaseResolveDependenciesTask>("resolveDependencies")
  }

  /**
   * Handle the default repository for this project
   */
  private fun handleRepository(project: Project) {
    Maven.repositories.forEach { repo ->
      project.repositories.maven(URI.create(repo.url)) {
        name = repo.name
      }
    }

    project.repositories.mavenCentral()
    project.repositories.google()
    project.repositories.mavenLocal()
  }

  /**
   * Delete some directory...
   */
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
