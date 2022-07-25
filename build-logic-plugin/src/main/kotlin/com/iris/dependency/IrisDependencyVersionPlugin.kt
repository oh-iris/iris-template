package com.iris.dependency

import org.gradle.api.Plugin
import org.gradle.api.Project

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
  }
}