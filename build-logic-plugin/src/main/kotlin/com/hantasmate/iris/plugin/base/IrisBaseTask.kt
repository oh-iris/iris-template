/*
 * copyright(c) 2018-2022 tabuyos all right reserved.
 */
package com.hantasmate.iris.plugin.base

import com.hantasmate.iris.plugin.IrisTask
import org.gradle.api.Project
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.TaskProvider
import org.gradle.kotlin.dsl.register

/**
 * IrisBaseTask
 *
 * @author tabuyos
 * @since 2022/7/25
 */
abstract class IrisBaseTask : IrisTask() {
  @get:Input
  abstract val greeting: Property<String>

  @TaskAction
  fun greet() {
    println(greeting.get())
  }
}
