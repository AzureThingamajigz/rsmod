version = "1.0.0-SNAPSHOT"

dependencies {
    implementation(project(":util"))
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:${JacksonVersions.JACKSON}")
    implementation("io.netty:netty-buffer:${NetVersions.NETTY}")
}
