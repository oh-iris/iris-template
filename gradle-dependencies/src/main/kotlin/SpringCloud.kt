/**
 * SpringBoot
 *
 * @author tabuyos
 * @since 2022/7/25
 */
@Suppress("unused")
object SpringCloud {
  val bom = create(
    group = "org.springframework.cloud",
    name = "spring-cloud-dependencies",
    version = Version.springCloud
  )

  val functionWeb = create(
    group = "org.springframework.cloud",
    name = "spring-cloud-function-web"
  )
  val circuitbreakerReactorResilience4j = create(
    group = "org.springframework.cloud",
    name = "spring-cloud-starter-circuitbreaker-reactor-resilience4j"
  )
  val gateway = create(
    group = "org.springframework.cloud",
    name = "spring-cloud-starter-gateway"
  )
  val functionContext = create(
    group = "org.springframework.cloud",
    name = "spring-cloud-function-context"
  )
  val openfeign = create(
    group = "org.springframework.cloud",
    name = "spring-cloud-starter-openfeign"
  )
  val loadbalancer = create(
    group = "org.springframework.cloud",
    name = "spring-cloud-starter-loadbalancer"
  )
  val bootstrap = create(
    group = "org.springframework.cloud",
    name = "spring-cloud-starter-bootstrap"
  )
}
