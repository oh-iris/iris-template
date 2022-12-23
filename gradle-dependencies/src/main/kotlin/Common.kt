/**
 * Common
 *
 * @author tabuyos
 * @since 2022/7/25
 */
@Suppress("unused")
object Common {
  // sharding
  val shardingJdbc = create(
    group = "org.apache.shardingsphere",
    name = "shardingsphere-jdbc-core",
    version = Version.shardingsphere
  )
  val shardingJdbcSpring = create(
    group = "org.apache.shardingsphere",
    name = "shardingsphere-jdbc-core-spring",
    version = Version.shardingsphere
  )
  val shardingJdbcSpringNamespace = create(
    group = "org.apache.shardingsphere",
    name = "shardingsphere-jdbc-core-spring-namespace",
    version = Version.shardingsphere
  )
  val shardingJdbcSpringBootStarter = create(
    group = "org.apache.shardingsphere",
    name = "shardingsphere-jdbc-core-spring-boot-starter",
    version = Version.shardingsphere
  )
  val shardingsphereSqlTranslatorJooqProvider = create(
    group = "org.apache.shardingsphere",
    name = "shardingsphere-sql-translator-jooq-provider",
    version = Version.shardingsphere
  )

  // cache
  val redisson = create(
    group = "org.redisson",
    name = "redisson",
    version = Version.redisson
  )
  val redissonSpringBootStarter = create(
    group = "org.redisson",
    name = "redisson-spring-boot-starter",
    version = Version.redisson
  )

  // http request
  val oktaSpringBootStarter = create(
    group = "com.okta.spring",
    name = "okta-spring-boot-starter",
    version = Version.okta
  )

  // database connection pool
  val druid = create(
    group = "com.alibaba",
    name = "druid",
    version = Version.druid
  )

  // lambda
  val jool = create(
    group = "org.jooq",
    name = "jool",
    version = Version.jool
  )
  val fugue = create(
    group = "io.atlassian.fugue",
    name = "fugue",
    version = Version.fugue
  )
  val jool8 = create(
    group = "org.jooq",
    name = "jool-java-8",
    version = Version.jool
  )
  val streamEx = create(
    group = "one.util",
    name = "streamex",
    version = Version.streamEx
  )
  val functionalJava = create(
    group = "org.functionaljava",
    name = "functionaljava",
    version = Version.functionalJava
  )
  val functionalJavaQuickCheck = create(
    group = "org.functionaljava",
    name = "functionaljava-quickcheck",
    version = Version.functionalJava
  )
  val functionalJavaCore = create(
    group = "org.functionaljava",
    name = "functionaljava-java-core",
    version = Version.functionalJava
  )

  // fluent
  val joor = create(
    group = "org.jooq",
    name = "joor",
    version = Version.joor
  )
  val joor8 = create(
    group = "org.jooq",
    name = "joor-java-8",
    version = Version.joor
  )

  // json
  val jacksonBom = create(
    group = "com.fasterxml.jackson",
    name = "jackson-bom",
    version = Version.jackson
  )
  val jacksonDatabind = create(
    group = "com.fasterxml.jackson.core",
    name = "jackson-databind",
    version = Version.jackson
  )
  val jacksonDataformatYaml = create(
    group = "com.fasterxml.jackson.dataformat",
    name = "jackson-dataformat-yaml",
    version = Version.jackson
  )
  val jacksonDataformatXml = create(
    group = "com.fasterxml.jackson.dataformat",
    name = "jackson-dataformat-xml",
    version = Version.jackson
  )

  // test
  val assertjParentPom = create(
    group = "org.assertj",
    name = "assertj-parent-pom",
    version = Version.assertj
  )
  val assertjCore = create(
    group = "org.assertj",
    name = "assertj-core",
    version = Version.assertjCore
  )
  val assertjGuave = create(
    group = "org.assertj",
    name = "assertj-guava",
    version = Version.assertjGuava
  )
  val junitBom = create(
    group = "org.junit",
    name = "junit-bom",
    version = Version.junit
  )
  val junitJupiterApi = create(
    group = "org.junit",
    name = "junit-jupiter-api",
    version = Version.junit
  )
  val junitJupiterEngine = create(
    group = "org.junit",
    name = "junit-jupiter-engine",
    version = Version.junit
  )
  val junitPlatformEngine = create(
    group = "org.junit",
    name = "junit-platform-engine",
    version = Version.junit
  )
  val mockitoBom = create(
    group = "org.mockito",
    name = "mockito-bom",
    version = Version.mockito
  )
  val mockitoJunitJupiter = create(
    group = "org.mockito",
    name = "mockito-junit-jupiter",
    version = Version.mockito
  )
  val mockitoCore = create(
    group = "org.mockito",
    name = "mockito-core",
    version = Version.mockito
  )
  val mockitoInline = create(
    group = "org.mockito",
    name = "mockito-inline",
    version = Version.mockito
  )
  val jmockit = create(
    group = "org.jmockit",
    name = "jmockit",
    version = Version.jmockit
  )
  val testcontainersBom = create(
    group = "org.testcontainers",
    name = "testcontainers-bom",
    version = Version.testcontainers
  )
  val testcontainersMysql = create(
    group = "org.testcontainers",
    name = "testcontainers-mysql",
    version = Version.testcontainers
  )
  val testcontainers = create(
    group = "org.testcontainers",
    name = "testcontainers",
    version = Version.testcontainers
  )

  // other
  val log4j2Bom = create(
    group = "org.apache.logging.log4j",
    name = "log4j-bom",
    version = Version.log4j2
  )
  val log4jSpringBoot = create(
    group = "org.apache.logging.log4j",
    name = "log4j-spring-boot",
    version = Version.log4j2
  )
  val reactorBom = create(
    group = "io.projectreactor",
    name = "reactor-bom",
    version = Version.reactor
  )
  val okhttpBom = create(
    group = "com.squareup.okhttp3",
    name = "okhttp-bom",
    version = Version.okhttp
  )
  val jetbrainsAnnotations = create(
    group = "org.jetbrains",
    name = "annotations",
    version = Version.jetbrainsAnnotations
  )
  val jasypt = create(
    group = "com.github.ulisesbocchio",
    name = "jasypt-spring-boot-starter",
    version = Version.jasypt
  )
  val commonsEmail = create(
    group = "org.apache.commons",
    name = "commons-email",
    version = Version.commonsEmail
  )

  // netty
  val nettyBom = create(
    group = "io.netty",
    name = "netty-bom",
    version = Version.netty
  )
  val nettyResolverDnsNativeMacos = create(
    group = "io.netty",
    name = "netty-resolver-dns-native-macos",
    version = Version.netty
  )
  val nettyResolverDnsClassesMacos = create(
    group = "io.netty",
    name = "netty-resolver-dns-classes-macos",
    version = Version.netty
  )
  val nettyAll = create(
    group = "io.netty",
    name = "netty-all",
    version = Version.netty
  )
  val nettyTransportNativeEpoll = create(
    group = "io.netty",
    name = "netty-transport-native-epoll",
    version = Version.netty
  )

  // gRPC
  val grpcServerSpringBootStarter = create(
    group = "net.devh",
    name = "grpc-server-spring-boot-starter",
    version = Version.grpcSpringBootStarter
  )

  val grpcClientSpringBootStarter = create(
    group = "net.devh",
    name = "grpc-client-spring-boot-starter",
    version = Version.grpcSpringBootStarter
  )

  val grpcSpringBootStarter = create(
    group = "net.devh",
    name = "grpc-spring-boot-starter",
    version = Version.grpcSpringBootStarter
  )

  // net-ip
  val ipAddress = create(
    group = "com.github.seancfoley",
    name = "ipaddress",
    version = Version.ipAddress,
  )

  // id generator
  val jnanoid = create(
    group = "com.aventrix.jnanoid",
    name = "jnanoid",
    version = Version.jnanoid,
  )

  // hutool
  val hutoolBom = create(
    group = "cn.hutool",
    name = "hutool-bom",
    version = Version.hutool,
  )
  val hutoolAll = create(
    group = "cn.hutool",
    name = "hutool-all",
    version = Version.hutool,
  )
  val hutoolCrypto = create(
    group = "cn.hutool",
    name = "hutool-crypto",
    version = Version.hutool,
  )

  // lombok
  val lombok = create(
    group = "org.projectlombok",
    name = "lombok",
    version = Version.lombok,
  )

  // docs
  val restdocsApiSpec = create(
    group = "com.epages",
    name = "restdocs-api-spec",
    version = Version.restdocsApiSpec,
  )
  val restdocsApiSpecMockmvc = create(
    group = "com.epages",
    name = "restdocs-api-spec-mockmvc",
    version = Version.restdocsApiSpec,
  )
  val restdocsApiSpecWebTestClient = create(
    group = "com.epages",
    name = "restdocs-api-spec-webtestclient",
    version = Version.restdocsApiSpec,
  )
  val restdocsApiSpecJsonschema = create(
    group = "com.epages",
    name = "restdocs-api-spec-jsonschema",
    version = Version.restdocsApiSpec,
  )
}
