import org.gradle.api.Project
import org.gradle.kotlin.dsl.java

plugins {
  java
}

fun handleNewProject(project: Project) {
  if (project.projectDir.resolve("src").exists().not()) {
    buildDirectory(project)
  }

  removeParentScr(project)
}

/**
 * Delete some directory...
 */
fun deleteDirectory(file: File): Boolean {
  if (file.isFile) {
    return file.delete()
  } else {
    val childFiles = file.listFiles() ?: return file.delete()
    childFiles.forEach {
      deleteDirectory(it)
    }
  }
  return file.delete()
}

/**
 * build project struct of directory
 *
 * @param project project
 */
fun buildDirectory(project: Project) {
  val javaPluginExtension = project.extensions.getByType(JavaPluginExtension::class)
  javaPluginExtension.sourceSets.forEach {
    createNewFolder(it.java.srcDirs)
    createNewFolder(it.resources.srcDirs)
  }
  buildScript(project)
}

fun buildScript(project: Project) {
  val file = project.projectDir.resolve("build.gradle.kts")
  if (file.exists().not()) {
    file.createNewFile()
  }
}

fun  removeParentScr(project: Project) {
  val file = project.projectDir.parentFile.resolve("src")
  if (file.exists()) {
    deleteDirectory(file)
  }
}

/**
 * create new folder if not exist
 *
 * @param files file sources
 */
fun createNewFolder(files: Set<File>) {
  files.forEach {
    if (it.exists().not()) {
      it.mkdirs()
    }
  }
}

handleNewProject(project)

tasks.register("hello") {
  group = "iris"
  doLast {
    println("manual execution...")
  }
}
