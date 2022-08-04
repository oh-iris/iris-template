/*
 * copyright(c) 2018-2022 tabuyos all right reserved.
 */
package com.hantasmate.iris.plugin.library

import com.hantasmate.iris.plugin.IrisPlugin
import com.hantasmate.iris.plugin.base.IrisBasePlugin
import org.gradle.api.Project
import org.gradle.api.plugins.ApplicationPlugin
import org.gradle.api.plugins.JavaLibraryPlugin
import org.gradle.kotlin.dsl.apply

/**
 * IrisLibraryPlugin
 *
 * @author tabuyos
 * @since 2022/7/25
 */
class IrisLibraryPlugin : IrisPlugin() {
  override fun apply(project: Project) {
    handlePlugin(project)
  }

  /**
   * Handle the default plugin for this project
   */
  private fun handlePlugin(project: Project) {
    project.pluginManager.apply(JavaLibraryPlugin::class)
    project.pluginManager.apply(IrisBasePlugin::class)
  }
}
