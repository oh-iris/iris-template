/*
 * copyright(c) 2018-2022 tabuyos all right reserved.
 */
package com.hantasmate.iris.plugin.base

import Maven
import Version
import com.hantasmate.iris.dsl.configure
import com.hantasmate.iris.plugin.IrisPlugin
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.plugins.quality.Checkstyle
import org.gradle.api.plugins.quality.CheckstyleExtension
import org.gradle.api.plugins.quality.CheckstylePlugin
import org.gradle.api.provider.Property
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.api.tasks.testing.Test
import org.gradle.jvm.toolchain.JavaLanguageVersion
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
  abstract val project: Property<Project>

  override fun apply(project: Project) {
    this.project.set(project)
    FileRef.of(project)

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
    project.pluginManager.apply(CheckstylePlugin::class)
  }

  /**
   * Handle the default extension for this project, making it configurable
   */
  private fun handleExtension(project: Project) {
    val baseExtension = project.extensions.create(extensionName, IrisBaseExtension::class)

    baseExtension.configure {
      it.removeParentSrc.set(true)
    }
    // override default settings
    // project.extensions.configure(JavaPluginExtension::class) {
    project.extensions.configure<JavaPluginExtension> {
      modularity.inferModulePath.set(true)
      sourceCompatibility = JavaVersion.toVersion(Version.java)
      targetCompatibility = JavaVersion.toVersion(Version.java)
      toolchain {
        languageVersion.set(JavaLanguageVersion.of(Version.java))
      }
    }
    project.extensions.configure<CheckstyleExtension> {
      toolVersion = Version.checkstyleTool
      maxWarnings = 0
      isIgnoreFailures = false
      isShowViolations = true
      config = project.rootProject.resources.text.fromFile("config/checkstyle/checkstyle.xml")
    }
  }

  private fun handleNewProject(project: Project) {
    project.rootProject.allprojects.forEach { subproject ->
      if (subproject.projectDir.exists()) {
        return
      }
      handlePlugin(subproject)
      buildDirectory(subproject)
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
    project.tasks.withType<Checkstyle> {
      source("src")
      include("**/*.java")
      exclude("**/gen/**", "**/test/**", "**/build/**")
    }
    project.tasks.withType<Test> {
      useJUnitPlatform()
      jvmArgs("--illegal-access=deny")
      jvmArgs("--add-opens", "java.base/java.lang=ALL-UNNAMED")
    }
    project.tasks.withType<JavaCompile> {
      modularity.inferModulePath.set(true)
      options.isWarnings = true
      options.encoding = "UTF-8"
      options.release.set(Version.java)
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
   * @param project project
   */
  private fun buildDirectory(project: Project) {
    val javaPluginExtension = project.extensions.getByType(JavaPluginExtension::class)
    javaPluginExtension.sourceSets.forEach {
      createNewFolder(it.java.srcDirs)
      createNewFolder(it.resources.srcDirs)
    }
    buildScript(project)
  }

  private fun buildScript(project: Project) {
    var file = File("${project.projectDir}${File.separator}build.gradle.kts")
    if (!file.exists()) {
      file.createNewFile()
    }
    file = File("${file.parentFile.parent}${File.separator}src")
    if (file.exists()) {
      deleteDirectory(file)
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
