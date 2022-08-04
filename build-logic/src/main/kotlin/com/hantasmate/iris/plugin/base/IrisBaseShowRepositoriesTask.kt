/*
 * copyright(c) 2018-2022 tabuyos all right reserved.
 */
package com.hantasmate.iris.plugin.base

import com.hantasmate.iris.plugin.IrisTask
import org.gradle.api.tasks.TaskAction

/**
 * IrisBaseResolveDependenciesTask
 *
 * @author tabuyos
 * @since 2022/7/25
 */
abstract class IrisBaseShowRepositoriesTask : IrisTask() {

  init {
    description = "Resolve repositories for the current project"
  }

  @TaskAction
  fun resolveDependencies() {
    println("All repositories:")
    project.repositories.forEach {
      println(it.name)
    }
  }
}
