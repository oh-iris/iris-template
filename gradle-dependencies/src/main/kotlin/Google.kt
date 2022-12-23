/**
 * Google
 *
 * @author tabuyos
 * @since 2022/7/25
 */
object Google {
  val guavaBom = create(
    group = "com.google.guava",
    name = "guava-bom",
    version = Version.guava
  )

  val grpcBom = create(
    group = "io.grpc",
    name = "grpc-bom",
    version = Version.grpc
  )

  val grpcNetty = create(
    group = "io.grpc",
    name = "grpc-netty",
    version = Version.grpc
  )

  val protobufBom = create(
    group = "com.google.protobuf",
    name = "protobuf-bom",
    version = Version.protobuf
  )

  val protobufGradlePlugin = create(
    group = "com.google.protobuf",
    name = "protobuf-gradle-plugin",
    version = Version.protobufPlugin
  )

  val guava = create(
    group = "com.google.guava",
    name = "guava",
    version = Version.guava
  )

  val gson = create(
    group = "com.google.code.gson",
    name = "gson",
    version = Version.gson
  )
}
