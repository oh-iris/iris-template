/**
 * Alibaba
 *
 * @author tabuyos
 * @since 2022/7/25
 */
@Suppress("unused")
object Alibaba {
  val bom = create(
    group = "com.alibaba.cloud",
    name = "spring-cloud-alibaba-dependencies",
    version = Version.alibabaCloud
  )

  // Alibaba Cloud
  val nacosConfig = create(
    group = "com.alibaba.cloud",
    name = "spring-cloud-starter-alibaba-nacos-config"
  )
  val nacosDiscovery = create(
    group = "com.alibaba.cloud",
    name = "spring-cloud-starter-alibaba-nacos-discovery"
  )
  val commons = create(
    group = "com.alibaba.cloud",
    name = "spring-cloud-alibaba-commons"
  )
  val docs = create(
    group = "com.alibaba.cloud",
    name = "spring-cloud-alibaba-docs"
  )
  val sentinel = create(
    group = "com.alibaba.cloud",
    name = "spring-cloud-starter-alibaba-sentinel"
  )
  val busRocketMq = create(
    group = "com.alibaba.cloud",
    name = "spring-cloud-starter-bus-rocketmq"
  )
  val streamRocketMq = create(
    group = "com.alibaba.cloud",
    name = "spring-cloud-starter-stream-rocketmq"
  )
  val sidecar = create(
    group = "com.alibaba.cloud",
    name = "spring-cloud-starter-alibaba-sidecar"
  )
  val sentinelDatasource = create(
    group = "com.alibaba.cloud",
    name = "spring-cloud-alibaba-sentinel-datasource"
  )
  val sentinelGateway = create(
    group = "com.alibaba.cloud",
    name = "spring-cloud-alibaba-sentinel-gateway"
  )
  val starters = create(
    group = "com.alibaba.cloud",
    name = "spring-cloud-alibaba-starters"
  )
  val circuitbreakerSentinel = create(
    group = "com.alibaba.cloud",
    name = "spring-cloud-circuitbreaker-sentinel"
  )
  val appactive = create(
    group = "com.alibaba.cloud",
    name = "spring-cloud-starter-alibaba-appactive"
  )
  val seata = create(
    group = "com.alibaba.cloud",
    name = "spring-cloud-starter-alibaba-seata"
  )

  // Alibaba Pay
  val alipaySdkJava = create(
    group = "com.alipay.sdk",
    name = "alipay-sdk-java",
    version = Version.alipaySdkJava
  )

  // Aliyun OSS
  val aliyunSdkOss = create(
    group = "com.aliyun.oss",
    name = "aliyun-sdk-oss",
    version = Version.aliyunSdkOss
  )
}
