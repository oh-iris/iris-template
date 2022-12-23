import com.google.protobuf.gradle.ProtobufExtension
import com.google.protobuf.gradle.id

plugins {
  id("com.google.protobuf")
}

val protobufVersion: String = "3.21.9"
val grpcVersion: String = "1.50.2"
val jakartaAnnotationApiVersion: String = "2.1.0"

dependencies {
  implementation(platform("com.google.protobuf:protobuf-bom:${protobufVersion}"))
  implementation(platform("io.grpc:grpc-bom:${grpcVersion}"))
  implementation("io.grpc:grpc-protobuf")
  implementation("io.grpc:grpc-stub")
  if (JavaVersion.current().isJava9Compatible) {
    implementation("jakarta.annotation:jakarta.annotation-api:${jakartaAnnotationApiVersion}")
  }
}

extensions.configure<ProtobufExtension> {
  protoc {
    artifact = "com.google.protobuf:protoc:3.21.9"
  }
  plugins {
    id("grpc") {
      artifact = "io.grpc:protoc-gen-grpc-java:1.50.2"
    }
  }
  generateProtoTasks {
    all().forEach {
      it.plugins {
        id("grpc") {
        }
      }
    }
  }
  generatedFilesBaseDir = "${projectDir}/src"
}

tasks.withType<Delete> {
  doFirst {
    file("${projectDir}/src/main/java").listFiles()?.forEach {
      delete.add(it)
    }
    file("${projectDir}/src/main/grpc").listFiles()?.forEach {
      delete.add(it)
    }
  }
}

configure<org.gradle.plugins.ide.idea.model.IdeaModel> {
  module {
    sourceDirs.add(file("${projectDir}/src/main/grpc"))
    sourceDirs.add(file("${projectDir}/src/main/java"))
    sourceDirs.add(file("${projectDir}/src/main/generated"))
    generatedSourceDirs.add(file("${projectDir}/src/main/java"))
    generatedSourceDirs.add(file("${projectDir}/src/main/grpc"))
    generatedSourceDirs.add(file("${projectDir}/src/main/generated"))
  }
}
