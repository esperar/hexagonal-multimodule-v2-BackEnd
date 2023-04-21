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
    annotation("common.annotation.UseCase")
    annotation("common.annotation.ReadOnlyUseCase")
    annotation("common.annotation.Service")
}