/*
 * copyright(c) 2018-2022 tabuyos all right reserved.
 */
package com.hantasmate.iris.dsl

import com.hantasmate.iris.plugin.IrisExtension
import org.gradle.api.Action

/**
 * IrisDslExtension
 *
 * @author tabuyos
 * @since 2022/7/30
 */

inline fun <T : IrisExtension> T.configure(action: (T) -> Unit): Unit {
  action(this)
}

fun <T : IrisExtension> T.configure(action: Action<in T>): Unit {
  action.execute(this)
}
