/*
 * copyright(c) 2018-2022 tabuyos all right reserved.
 */
package com.hantasmate.iris.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * IrisPlugin
 *
 * @author tabuyos
 * @since 2022/7/25
 */
abstract class IrisPlugin : Plugin<Project> {
  override fun apply(project: Project) {}
}
