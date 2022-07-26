/*
 * copyright(c) 2018-2022 tabuyos all right reserved.
 */
package com.hantasmate.iris.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * IrisTask
 *
 * @author tabuyos
 * @since 2022/7/25
 */
abstract class IrisTask : DefaultTask() {

  init {
    group = "iris"
    description = "Iris Task for Project"
  }

  @TaskAction
  open fun taskAction() {
    println("Thanks for using the Iris plugin.")
  }
}
