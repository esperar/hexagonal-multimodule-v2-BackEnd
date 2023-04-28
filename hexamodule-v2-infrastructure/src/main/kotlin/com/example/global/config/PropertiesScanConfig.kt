package com.example.global.config

import com.example.global.security.properties.SecurityProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration

@ConfigurationPropertiesScan(
    basePackageClasses = [
        SecurityProperties::class
    ]
)
@Configuration
class PropertiesScanConfig