package com.bantolomeus.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration


@Configuration
@ConfigurationProperties
//(prefix = "info")
open class InfoConfiguration {

    var buildVersion: String = ""

}