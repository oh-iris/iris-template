package com.iris.dependency

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.repositories

/**
 * IrisDependencyVersionPlugin
 *
 * @author bjliu(a.k.a tabuyos)
 * @since 2022/7/25
 */
class IrisDependencyVersionPlugin : Plugin<Project> {
  override fun apply(project: Project) {
    project.plugins.apply("java")
    project.plugins.apply("java-library")
    val extension = project.extensions.create("myex", MyExtension::class.java)
    extension.libs = project.extensions.getByType(VersionCatalogsExtension::class.java).named("libs")
//    project.repositories.mavenCentral()
    project.repositories {
      mavenCentral()
    }
  }
}

abstract class MyExtension {
  abstract var libs: VersionCatalog
  abstract val name: Property<String>

  init {
    name.convention("tabuyos")
  }
}
