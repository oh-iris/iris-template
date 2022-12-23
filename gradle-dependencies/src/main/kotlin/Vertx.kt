/**
 * Vertx
 *
 * @author tabuyos
 * @since 2022/11/9
 */
object Vertx {
  val bom = create(
    group = "io.vertx",
    name = "vertx-stack-depchain",
    version = Version.vertx
  )
  val core = create(
    group = "io.vertx",
    name = "vertx-core",
    version = Version.vertx
  )
}
