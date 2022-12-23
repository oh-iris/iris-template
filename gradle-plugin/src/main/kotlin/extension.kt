/*
 * copyright(c) 2018-2022 tabuyos all right reserved.
 */

@file:Suppress("unused")

import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.DependencyConstraint
import org.gradle.api.artifacts.ExternalModuleDependency
import org.gradle.api.artifacts.dsl.DependencyConstraintHandler
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.accessors.runtime.addDependencyTo
import org.gradle.kotlin.dsl.apply
import java.util.*

/**
 * 暂时不想拆分, 先放在一起吧
 *
 * @author tabuyos
 * @since 2022/7/30
 */
class Notation<K, V> : LinkedHashMap<K, V>()

const val GROUP: String = "group"
const val NAME: String = "name"
const val VERSION: String = "version"
const val CONFIGURATION: String = "configuration"
const val CLASSIFIER: String = "classifier"
const val EXT: String = "ext"

val KEY_MAP = mapOf(
  0 to GROUP,
  1 to NAME,
  2 to VERSION,
  3 to CLASSIFIER,
  4 to CONFIGURATION,
  5 to EXT
)


fun withPlugin(project: Project, clazz: kotlin.reflect.KClass<out Plugin<*>>) {
  if (project.plugins.hasPlugin(clazz.java).not()) {
    project.pluginManager.apply(clazz)
  }
}


fun <T> List<T>.optional(): Optional<List<T>> {
  return Optional.ofNullable(this)
}


fun String.split(): List<String> {
  return this.split(":")
}


fun <K, V> notationOf(): Notation<K, V> = Notation()


fun mapOfNonNullValuesOf(vararg entries: Pair<String?, String?>): Notation<String, String> =
  notationOf<String, String>().apply {
    for ((k, v) in entries) {
      if (k != null && v != null) {
        put(k, v)
      }
    }
  }


fun create(notation: String): Notation<String, String> {
  return notation.split()
    .optional()
    .filter { it.size > 1 }
    .map {
      val pairs = mutableListOf<Pair<String?, String?>>()
      it.indices.forEach { idx ->
        val key = KEY_MAP.getOrDefault(idx, null)
        val value = it.getOrNull(idx)
        pairs.add(key to value)
      }
      return@map mapOfNonNullValuesOf(*pairs.toTypedArray())
    }
    .orElse(mapOfNonNullValuesOf())
}


fun create(
  group: String,
  name: String,
  version: String? = null,
  configuration: String? = null,
  classifier: String? = null,
  ext: String? = null
): Notation<String, String> = mapOfNonNullValuesOf(
  GROUP to group,
  NAME to name,
  VERSION to version,
  CONFIGURATION to configuration,
  CLASSIFIER to classifier,
  EXT to ext
)


fun Notation<String, String>.noVersion(): Notation<String, String> {
  this.remove(VERSION)
  return this
}


fun Notation<String, String>.noClassifier(): Notation<String, String> {
  this.remove(CLASSIFIER)
  return this
}


fun Notation<String, String>.withVersion(version: String?): Notation<String, String> {
  if (version != null) {
    this[VERSION] = version
  }
  return this
}


fun Notation<String, String>.withClassifier(classifier: String?): Notation<String, String> {
  if (classifier != null) {
    this[CLASSIFIER] = classifier
  }
  return this
}



fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
  add("implementation", dependencyNotation)

fun DependencyHandler.implementation(
  dependencyNotation: Any,
  dependencyConfiguration: Action<ExternalModuleDependency>
): ExternalModuleDependency = addDependencyTo(
  this, "implementation", dependencyNotation, dependencyConfiguration
)

fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? =
  add("testImplementation", dependencyNotation)

fun DependencyHandler.testImplementation(
  dependencyNotation: Any,
  dependencyConfiguration: Action<ExternalModuleDependency>
): ExternalModuleDependency = addDependencyTo(
  this, "testImplementation", dependencyNotation, dependencyConfiguration
)

fun DependencyHandler.api(dependencyNotation: Any): Dependency? =
  add("api", dependencyNotation)

fun DependencyHandler.api(
  dependencyNotation: Any,
  dependencyConfiguration: Action<ExternalModuleDependency>
): ExternalModuleDependency = addDependencyTo(
  this, "api", dependencyNotation, dependencyConfiguration
)

fun DependencyHandler.annotationProcessor(dependencyNotation: Any): Dependency? =
  add("annotationProcessor", dependencyNotation)

fun DependencyHandler.annotationProcessor(
  dependencyNotation: Any,
  dependencyConfiguration: Action<ExternalModuleDependency>
): ExternalModuleDependency = addDependencyTo(
  this, "annotationProcessor", dependencyNotation, dependencyConfiguration
)

fun DependencyHandler.compileOnly(dependencyNotation: Any): Dependency? =
  add("compileOnly", dependencyNotation)

fun DependencyHandler.compileOnly(
  dependencyNotation: Any,
  dependencyConfiguration: Action<ExternalModuleDependency>
): ExternalModuleDependency = addDependencyTo(
  this, "compileOnly", dependencyNotation, dependencyConfiguration
)

fun DependencyHandler.runtimeOnly(dependencyNotation: Any): Dependency? =
  add("runtimeOnly", dependencyNotation)

fun DependencyHandler.runtimeOnly(
  dependencyNotation: Any,
  dependencyConfiguration: Action<ExternalModuleDependency>
): ExternalModuleDependency = addDependencyTo(
  this, "runtimeOnly", dependencyNotation, dependencyConfiguration
)

fun DependencyHandler.testCompileOnly(dependencyNotation: Any): Dependency? =
  add("testCompileOnly", dependencyNotation)

fun DependencyHandler.testCompileOnly(
  dependencyNotation: Any,
  dependencyConfiguration: Action<ExternalModuleDependency>
): ExternalModuleDependency = addDependencyTo(
  this, "testCompileOnly", dependencyNotation, dependencyConfiguration
)

fun DependencyHandler.testRuntimeOnly(dependencyNotation: Any): Dependency? =
  add("testRuntimeOnly", dependencyNotation)

fun DependencyHandler.testRuntimeOnly(
  dependencyNotation: Any,
  dependencyConfiguration: Action<ExternalModuleDependency>
): ExternalModuleDependency = addDependencyTo(
  this, "testRuntimeOnly", dependencyNotation, dependencyConfiguration
)


fun DependencyConstraintHandler.implementation(dependencyNotation: Any): DependencyConstraint =
  add("implementation", dependencyNotation)

fun DependencyConstraintHandler.testImplementation(dependencyNotation: Any): DependencyConstraint =
  add("testImplementation", dependencyNotation)

fun DependencyConstraintHandler.api(dependencyNotation: Any): DependencyConstraint =
  add("api", dependencyNotation)

fun DependencyConstraintHandler.compileOnly(dependencyNotation: Any): DependencyConstraint =
  add("compileOnly", dependencyNotation)

fun DependencyConstraintHandler.runtimeOnly(dependencyNotation: Any): DependencyConstraint =
  add("runtimeOnly", dependencyNotation)

fun DependencyConstraintHandler.testCompileOnly(dependencyNotation: Any): DependencyConstraint =
  add("compileOnly", dependencyNotation)

fun DependencyConstraintHandler.testRuntimeOnly(dependencyNotation: Any): DependencyConstraint =
  add("runtimeOnly", dependencyNotation)
