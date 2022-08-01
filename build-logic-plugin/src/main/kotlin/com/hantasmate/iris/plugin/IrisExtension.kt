/*
 * copyright(c) 2018-2022 tabuyos all right reserved.
 */
package com.hantasmate.iris.plugin

import org.gradle.api.Action
import org.gradle.api.provider.Property
import java.util.*

/**
 * IrisExtension
 *
 * @author tabuyos
 * @since 2022/7/25
 */
abstract class IrisExtension {
  abstract val name: Property<String>
}
