/**
 * SpringBoot
 *
 * @author tabuyos
 * @since 2022/7/25
 */
@Suppress("unused")
object SpringBoot {
  val bom = create(
    group = "org.springframework.boot",
    name = "spring-boot-dependencies",
    version = Version.springBoot
  )

  val gradlePlugin = create(
    group = "org.springframework.boot",
    name = "spring-boot-gradle-plugin",
    version = Version.springBoot
  )
  val amqp = create(
    group = "org.springframework.boot",
    name = "spring-boot-starter-amqp"
  )
  val dataR2dbc = create(
    group = "org.springframework.boot",
    name = "spring-boot-starter-data-r2dbc"
  )
  val redis = create(
    group = "org.springframework.boot",
    name = "spring-boot-starter-data-redis"
  )
  val redisReactive = create(
    group = "org.springframework.boot",
    name = "spring-boot-starter-data-redis-reactive"
  )
  val jooq = create(
    group = "org.springframework.boot",
    name = "spring-boot-starter-jooq"
  )
  val autoconfigure = create(
    group = "org.springframework.boot",
    name = "spring-boot-autoconfigure"
  )
  val jooqCodegen = create(
    group = "org.jooq",
    name = "jooq-codegen"
  )
  val jakartaAnnotationApi = create(
    group = "jakarta.annotation",
    name = "jakarta.annotation-api"
  )
  val jakartaPersistenceApi = create(
    group = "jakarta.persistence",
    name = "jakarta.persistence-api"
  )
  val jakartaValidationApi = create(
    group = "jakarta.validation",
    name = "jakarta.validation-api"
  )
  val mail = create(
    group = "org.springframework.boot",
    name = "spring-boot-starter-mail"
  )
  val oauth2Client = create(
    group = "org.springframework.boot",
    name = "spring-boot-starter-oauth2-client"
  )
  val oauth2ResourceServer = create(
    group = "org.springframework.boot",
    name = "spring-boot-starter-oauth2-resource-server"
  )
  val rsocket = create(
    group = "org.springframework.boot",
    name = "spring-boot-starter-rsocket"
  )
  val security = create(
    group = "org.springframework.boot",
    name = "spring-boot-starter-security"
  )
  val oauth2AuthorizationServer = create(
    group = "org.springframework.security",
    name = "spring-security-oauth2-authorization-server",
    version = Version.oauth2AuthorizationServer
  )
  val starter = create(
    group = "org.springframework.boot",
    name = "spring-boot-starter"
  )
  val web = create(
    group = "org.springframework.boot",
    name = "spring-boot-starter-web"
  )
  val restdocsWebTestClient = create(
    group = "org.springframework.restdocs",
    name = "spring-restdocs-webtestclient"
  )
  val restdocsMockmvc = create(
    group = "org.springframework.restdocs",
    name = "spring-restdocs-mockmvc"
  )
  val jdbc = create(
    group = "org.springframework.boot",
    name = "spring-boot-starter-jdbc"
  )
  val cache = create(
    group = "org.springframework.boot",
    name = "spring-boot-starter-cache"
  )
  val log4j2 = create(
    group = "org.springframework.boot",
    name = "spring-boot-starter-log4j2"
  )
  val logging = create(
    group = "org.springframework.boot",
    name = "spring-boot-starter-logging"
  )
  val webServices = create(
    group = "org.springframework.boot",
    name = "spring-boot-starter-web-services"
  )
  val webflux = create(
    group = "org.springframework.boot",
    name = "spring-boot-starter-webflux"
  )
  val websocket = create(
    group = "org.springframework.boot",
    name = "spring-boot-starter-websocket"
  )
  val devtools = create(
    group = "org.springframework.boot",
    name = "spring-boot-devtools"
  )
  val configurationProcessor = create(
    group = "org.springframework.boot",
    name = "spring-boot-configuration-processor",
    version = Version.springBoot
  )
  val test = create(
    group = "org.springframework.boot",
    name = "spring-boot-starter-test"
  )
  val reactorTest = create(
    group = "io.projectreactor",
    name = "reactor-test"
  )
  val reactorCore = create(
    group = "io.projectreactor",
    name = "reactor-core"
  )
  val rabbitTest = create(
    group = "org.springframework.amqp",
    name = "spring-rabbit-test"
  )
  val kafkaTest = create(
    group = "org.springframework.kafka",
    name = "spring-kafka-test"
  )
  val securityTest = create(
    group = "org.springframework.security",
    name = "spring-security-test"
  )

  val flywayCore = create(
    group = "org.flywaydb",
    name = "flyway-core"
  )
  val flywayMysql = create(
    group = "org.flywaydb",
    name = "flyway-mysql"
  )
  val h2 = create(
    group = "com.h2database",
    name = "h2"
  )
  val mysql = create(
    group = "mysql",
    name = "mysql-connector-java"
  )
  val mariadbR2dbc = create(
    group = "org.mariadb",
    name = "r2dbc-mariadb"
  )
  val mariadb = create(
    group = "org.mariadb.jdbc",
    name = "mariadb-java-client"
  )
  val caffeine = create(
    group = "com.github.ben-manes.caffeine",
    name = "caffeine"
  )

  val jacksonModuleKotlin = create(
    group = "com.fasterxml.jackson.module",
    name = "jackson-module-kotlin"
  )
  val reactorKotlinExtensions = create(
    group = "io.projectreactor.kotlin",
    name = "reactor-kotlin-extensions"
  )
  val kotlinReflect = create(
    group = "org.jetbrains.kotlin",
    name = "kotlin-reflect"
  )
  val kotlinStdlibJdk8 = create(
    group = "org.jetbrains.kotlin",
    name = "kotlin-stdlib-jdk8"
  )
  val kotlinxCoroutinesReactor = create(
    group = "org.jetbrains.kotlinx",
    name = "kotlinx-coroutines-reactor"
  )
  val tomcatEmbedCore = create(
    group = "org.apache.tomcat.embed",
    name = "tomcat-embed-core"
  )
}
