/**
 * Spring
 *
 * @author tabuyos
 * @since 2022/7/25
 */
object Spring {
  val jdbc = create(
    group = "org.springframework",
    name = "spring-jdbc"
  )
  val kafka = create(
    group = "org.springframework.kafka",
    name = "spring-kafka"
  )
  val securityMessageing = create(
    group = "org.springframework.security",
    name = "spring-security-messaging"
  )
  val securityRsocket = create(
    group = "org.springframework.security",
    name = "spring-security-rsocket"
  )
  val securityCrypto = create(
    group = "org.springframework.security",
    name = "spring-security-crypto"
  )
  val securityCore = create(
    group = "org.springframework.security",
    name = "spring-security-core"
  )
}
