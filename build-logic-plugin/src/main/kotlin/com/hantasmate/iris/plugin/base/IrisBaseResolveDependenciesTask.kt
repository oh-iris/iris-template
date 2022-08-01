/*
 * copyright(c) 2018-2022 tabuyos all right reserved.
 */
package com.hantasmate.iris.plugin.base

import com.hantasmate.iris.plugin.IrisTask
import org.gradle.api.artifacts.Configuration
import org.gradle.api.tasks.TaskAction

/**
 * IrisBaseResolveDependenciesTask
 *
 * @author tabuyos
 * @since 2022/7/25
 */
abstract class IrisBaseResolveDependenciesTask : IrisTask() {

  init {
    description = "Resolve dependencies for the whole project"
  }

  @TaskAction
  fun resolveDependencies() {
    project.rootProject.allprojects {
      val configurations: Set<Configuration> = project.buildscript.configurations + project.configurations
      configurations
        .filter { predicate: Configuration -> predicate.isCanBeResolved }
        .forEach { configuration: Configuration -> configuration.resolve() }
    }
  }
}
