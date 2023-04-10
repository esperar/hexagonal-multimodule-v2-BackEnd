object Dependencies {

    // kotlin
    const val KOTLIN_REFLECT = "org.jetbrains.kotlin:kotlin-reflect"
    const val KOTLIN_JDK = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
    const val JACKSON = "com.fasterxml.jackson.module:jackson-module-kotlin:${DependencyVersions.JACKSON_VERSION}"
    const val JACKSON_TYPE = "com.fasterxml.jackson.datatype:jackson-datatype-jsr310:${DependencyVersions.JACKSON_VERSION}"

    const val JAVA_SERVLET = "javax.servlet:javax.servlet-api:${DependencyVersions.SERVLET_VERSION}"

    // web
    const val SPRING_WEB = "org.springframework.boot:spring-boot-starter-web"

    // validation
    const val SPRING_VALIDATION = "org.springframework.boot:spring-boot-starter-validation"

    // transaction
    const val SPRING_TRANSACTION = "org.springframework:spring-tx:${DependencyVersions.SPRING_TRANSACTION}"


    // configuration
    const val CONFIGURATION_PROCESSOR = "org.springframework.boot:spring-boot-configuration-processor"

    // database
    const val SPRING_DATA_JPA = "org.springframework.boot:spring-boot-starter-data-jpa:${PluginVersions.SPRING_BOOT_VERSION}"
    const val MYSQL_CONNECTOR = "mysql:mysql-connector-java:${DependencyVersions.MYSQL}"
    const val SPRING_REDIS = "org.springframework.boot:spring-boot-starter-data-redis:${PluginVersions.SPRING_BOOT_VERSION}"
    const val REDIS = "org.springframework.data:spring-data-redis:${DependencyVersions.REDIS_VERSION}"

    const val SPRING_SECURITY = "org.springframework.boot:spring-boot-starter-security"

    const val JWT = "io.jsonwebtoken:jjwt:${DependencyVersions.JWT_VERSION}"

    const val SPRING_AWS = "org.springframework.cloud:spring-cloud-starter-aws:${DependencyVersions.AWS_VERSION}"
    const val AWS_SES = "com.amazonaws:aws-java-sdk-ses:${DependencyVersions.SES_VERSION}"

    const val SPRING_TEST = "org.springframework.boot:spring-boot-starter-test:${PluginVersions.SPRING_BOOT_VERSION}"
    const val MOCKK = "io.mockk:mockk:${DependencyVersions.MOCKK_VERSION}"

    const val UUID_TIME = "com.fasterxml.uuid:java-uuid-generator:${DependencyVersions.UUID_TIME_VERSION}"

    const val APACHE_POI = "org.apache.poi:poi:${DependencyVersions.APACHE_POI_VERSION}"
    const val APACHE_POI_OOXML = "org.apache.poi:poi-ooxml:${DependencyVersions.APACHE_POI_VERSION}"

    const val SPRING_AOP = "org.springframework.boot:spring-boot-starter-aop:${PluginVersions.SPRING_BOOT_VERSION}"

    const val DETEKT = "io.gitlab.arturbosch.detekt:detekt-formatting:${PluginVersions.DETEKT_VERSION}"

    const val OPEN_FEIGN = "org.springframework.cloud:spring-cloud-starter-openfeign:${DependencyVersions.OPEN_FEIGN_VERSION}"

    const val GSON = "com.google.code.gson:gson"
}