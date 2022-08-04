/*
 * copyright(c) 2018-2022 tabuyos all right reserved.
 */
/**
 * FileRef
 *
 * @author tabuyos
 * @since 2022/7/26
 */
object Maven {

  val repositories = listOf(AliyunCentral, AliyunPublic, TencentPublic, HuaweiPublic)

  object AliyunCentral : Repository {
    override val url = "https://maven.aliyun.com/repository/central/"
    override val name = "AliyunCentral"
  }

  object AliyunPublic : Repository {
    override val url = "https://maven.aliyun.com/repository/public/"
    override val name = "AliyunPublic"
  }

  object TencentPublic : Repository {
    override val url = "https://mirrors.cloud.tencent.com/nexus/repository/maven-public/"
    override val name = "TencentPublic"
  }

  object HuaweiPublic : Repository {
    override val url = "https://repo.huaweicloud.com/repository/maven/"
    override val name = "HuaweiPublic"
  }
}
