/*
 * copyright(c) 2018-2022 tabuyos all right reserved.
 */
package com.hantasmate.iris.plugin.base

import com.hantasmate.iris.plugin.IrisExtension
import org.gradle.api.Action
import org.gradle.api.provider.Property

/**
 * IrisBaseExtension
 *
 * @author tabuyos
 * @since 2022/7/25
 */
abstract class IrisBaseExtension : IrisExtension() {
  abstract val version: Property<Int>
  abstract val removeParentSrc: Property<Boolean>
}
