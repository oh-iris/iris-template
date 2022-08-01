/*
 * copyright(c) 2018-2022 tabuyos all right reserved.
 */
package com.hantasmate.iris.plugin.base

import Maven
import com.hantasmate.iris.dsl.configure
import com.hantasmate.iris.plugin.IrisPlugin
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.api.tasks.testing.Test
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

    handleNewProject(project)
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
    val baseExtension = project.extensions.create(extensionName, IrisBaseExtension::class)

    baseExtension.configure {
    }
    // override default settings
    project.extensions.configure(JavaPluginExtension::class) {
      modularity.inferModulePath.set(true)
      sourceCompatibility = JavaVersion.VERSION_17
      targetCompatibility = JavaVersion.VERSION_17
      toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
      }
    }
  }

  private fun handleNewProject(project: Project) {
    project.rootProject.allprojects.forEach { subproject ->
      handlePlugin(subproject)
      val extension = subproject.extensions.getByType(JavaPluginExtension::class)
      buildDirectory(extension)
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
    project.tasks.register<IrisBaseShowRepositoriesTask>("showRepositories")
    project.tasks.withType(Test::class) {
      useJUnitPlatform()
      jvmArgs("--illegal-access=deny")
      jvmArgs("--add-opens", "java.base/java.lang=ALL-UNNAMED")
    }
    project.tasks.withType(JavaCompile::class) {
      modularity.inferModulePath.set(true)
      options.isWarnings = true
      options.encoding = "UTF-8"
      options.release.set(17)
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

  /**
   * build project struct of directory
   *
   * @param extension extension for java plugin
   */
  private fun buildDirectory(extension: JavaPluginExtension) {
    extension.sourceSets.forEach {
      createNewFolder(it.java.srcDirs)
      createNewFolder(it.resources.srcDirs)
    }
  }

  /**
   * create new folder if not exist
   *
   * @param files file sources
   */
  private fun createNewFolder(files: Set<File>) {
    files.forEach {
      if (!it.exists()) {
        it.mkdirs()
      }
    }
  }
}
