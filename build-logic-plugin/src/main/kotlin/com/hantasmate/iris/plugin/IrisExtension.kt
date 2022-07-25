/*
 * copyright(c) 2018-2022 tabuyos all right reserved.
 */
package com.hantasmate.iris.plugin

import org.gradle.api.provider.Property

/**
 * IrisExtension
 *
 * @author tabuyos
 * @since 2022/7/25
 */
interface IrisExtension {
  val name: Property<String>
}
