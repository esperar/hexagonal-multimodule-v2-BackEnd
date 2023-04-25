
plugins {
	kotlin("jvm") version PluginVersions.JVM_VERSION
}

repositories{
	mavenCentral()
}

subprojects {

	apply {
		plugin("org.jetbrains.kotlin.jvm")
		version = PluginVersions.JVM_VERSION
	}

	dependencies {
		implementation(Dependencies.SPRING_VALIDATION)
		implementation(Dependencies.SPRING_SECURITY)
		implementation(Dependencies.JWT)
		annotationProcessor(Dependencies.CONFIGURATION_PROCESSOR)
		implementation(Dependencies.JACKSON_TYPE)
		implementation(Dependencies.JAVA_SERVLET)
	}
}

allprojects {
	group = "com.example"
	version = "0.0.1-SNAPSHOT"

	apply(plugin = "jacoco")

	tasks {
		compileKotlin {
			kotlinOptions {
				freeCompilerArgs = listOf("-Xjsr305=strict")
				jvmTarget = "11"
			}
		}

		compileJava {
			sourceCompatibility = JavaVersion.VERSION_11.majorVersion
		}

		test {
			useJUnitPlatform()
		}
	}

	repositories {
		mavenCentral()
	}
}

tasks.register<JacocoReport>("jacocoRootReport") {
	subprojects {
		this@subprojects.plugins.withType<JacocoPlugin>().configureEach {
			this@subprojects.tasks.matching {
				it.extensions.findByType<JacocoTaskExtension>() != null
			}
				.configureEach {
					sourceSets(this@subprojects.the<SourceSetContainer>().named("main").get())
					executionData(this)
				}
		}
	}

	reports {
		xml.outputLocation.set(File("${buildDir}/reports/jacoco/test/jacocoTestReport.xml"))
		xml.required.set(true)
		html.required.set(false)
	}
}

tasks.getByName<Jar>("jar") {
	enabled = false
}