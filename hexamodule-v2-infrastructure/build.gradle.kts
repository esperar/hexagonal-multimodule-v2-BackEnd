plugins {
    id("org.springframework.boot") version PluginVersions.SPRING_BOOT_VERSION
    id("io.spring.dependency-management") version PluginVersions.DEPENDENCY_MANAGER_VERSION
    kotlin("plugin.spring") version PluginVersions.SPRING_PLUGIN_VERSION
    kotlin("plugin.jpa") version PluginVersions.JPA_PLUGIN_VERSION
}

repositories {
    mavenCentral()
}

dependencies {
    // impl project
    implementation(project(":hexamodule-v2-persistence"))
    implementation(project(":hexamodule-v2-core"))
    implementation(project(":hexamodule-v2-presentation"))

    // validation
    implementation(Dependencies.SPRING_VALIDATION)

    // security
    implementation(Dependencies.SPRING_SECURITY)

    // jwt
    implementation(Dependencies.JWT)

    // aws
    implementation(Dependencies.AWS_SES)
    implementation(Dependencies.SPRING_AWS)

    // configuration
    annotationProcessor(Dependencies.CONFIGURATION_PROCESSOR)

    // excel
    implementation(Dependencies.APACHE_POI)
    implementation(Dependencies.APACHE_POI_OOXML)

    // open feign
    implementation(Dependencies.OPEN_FEIGN)

    // gson
    implementation(Dependencies.GSON)

    // jackson
    implementation(Dependencies.JACKSON_TYPE)

}


tasks.getByName<Jar>("jar") {
    enabled = false
}