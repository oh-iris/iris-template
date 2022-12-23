/*
 * copyright(c) 2018-2022 tabuyos all right reserved.
 */
/**
 * Exclude
 *
 * @author tabuyos
 * @since 2022/10/11
 */
object Exclude {
  val springBootLogging = mapOf("group" to "org.springframework.boot", "module" to "spring-boot-starter-logging")
  val springBootActuator = mapOf("group" to "org.springframework.boot", "module" to "spring-boot-starter-actuator")
  val springBootSecurity = mapOf("group" to "org.springframework.boot", "module" to "spring-boot-starter-security")
  val log4j = mapOf("group" to "log4j", "module" to "log4j")
}
