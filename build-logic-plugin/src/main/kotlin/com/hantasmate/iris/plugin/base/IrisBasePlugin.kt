/*
 * copyright(c) 2018-2022 tabuyos all right reserved.
 */
package com.hantasmate.iris.plugin.base

import Maven
import com.hantasmate.iris.plugin.IrisPlugin
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.gradle.kotlin.dsl.*
import org.gradle.kotlin.dsl.configure
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

    handleDependency(project)
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
    val javaPluginExtension = project.extensions.getByName<JavaPluginExtension>("java")
    project.extensions.configure(JavaPluginExtension::class) { ext ->
      ext.modularity.inferModulePath.set(true)
      ext.sourceCompatibility = JavaVersion.VERSION_17
      ext.targetCompatibility = JavaVersion.VERSION_17
      ext.toolchain { chain ->
        chain.languageVersion.set(JavaLanguageVersion.of(17))
      }
    }
  }

  /**
   * Handle the default task for this project
   */
  private fun handleTask(project: Project) {
    project.tasks.register<IrisBaseTask>("welcome") {
      greeting.set("Welcome to Iris World.")
    }
    project.tasks.register<IrisBaseResolveDependenciesTask>("resolveDependencies")
    project.tasks.withType(JavaCompile::class) {
      it.modularity.inferModulePath.set(true)
      it.options.isWarnings = true
      it.options.encoding = "UTF-8"
      it.options.release.set(17)
    }
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
   * Handle the default dependency for this project
   */
  private fun handleDependency(project: Project) {
    // project.dependencies.add()
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
