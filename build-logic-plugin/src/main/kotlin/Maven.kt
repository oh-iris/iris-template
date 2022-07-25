import java.net.URI

object Maven {
  val aliyunCentral = AliyunCentral
  val aliyunPublic = AliyunPublic
  val tencentPublic = TencentPublic
  val huaweiPublic = HuaweiPublic

  object AliyunCentral {
    const val url = "https://maven.aliyun.com/repository/central/"
    const val name = "AliyunCentral"
  }

  object AliyunPublic {
    const val url = "https://maven.aliyun.com/repository/public/"
    const val name = "AliyunPublic"
  }

  object TencentPublic {
    const val url = "https://mirrors.cloud.tencent.com/nexus/repository/maven-public/"
    const val name = "TencentPublic"
  }

  object HuaweiPublic {
    const val url = "https://repo.huaweicloud.com/repository/maven/"
    const val name = "HuaweiPublic"
  }
}
