plugins {
    kotlin("plugin.allopen") version PluginVersions.ALLOPEN_VERSION
}

repositories {
    mavenCentral()
}

dependencies {

    // transaction
    implementation(Dependencies.SPRING_TRANSACTION)

    // aop

    implementation(Dependencies.SPRING_AOP)
}

allOpen {
    annotation("kotlin.common.annotation.UseCase")
    annotation("kotlin.common.annotation.ReadOnlyUseCase")
    annotation("kotlin.common.annotation.Service")
}