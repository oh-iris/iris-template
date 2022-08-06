import org.gradle.api.Project
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType
/**
 * FileRef
 *
 * @author tabuyos
 * @since 2022/7/26
 */
object FileRef {

  lateinit var project: Project
  lateinit var versionCatalog: VersionCatalog

  fun of(project: Project) {
    this.project = project
    generateCatalog()
  }

  private fun generateCatalog() {
    val catalogsExtension = project.extensions.getByType(VersionCatalogsExtension::class)
    versionCatalog = catalogsExtension.named("libs")
  }

  private fun getCatalog(): VersionCatalog {
    return versionCatalog
  }

  fun getLibrary(alias: String): MinimalExternalModuleDependency {
    return getCatalog().findLibrary(alias).get().get()
  }
}
