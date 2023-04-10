import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
	id("org.springframework.boot") version PluginVersions.SPRING_BOOT_VERSION
	id("io.spring.dependency-management") version PluginVersions.DEPENDENCY_MANAGER_VERSION
	kotlin("jvm") version PluginVersions.JVM_VERSION
	kotlin("plugin.spring") version PluginVersions.SPRING_PLUGIN_VERSION

	`kotlin-dsl`
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation(Dependencies.SPRING_VALIDATION)
	implementation(Dependencies.SPRING_SECURITY)
	implementation(Dependencies.JWT)
	implementation(Dependencies.AWS_SES)
	implementation(Dependencies.SPRING_AWS)
	annotationProcessor(Dependencies.CONFIGURATION_PROCESSOR)
	implementation(Dependencies.OPEN_FEIGN)
	implementation(Dependencies.GSON)
	implementation(Dependencies.JACKSON_TYPE)
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
