package com.bantolomeus.controller

import com.bantolomeus.configuration.InfoConfiguration
import com.bantolomeus.health.ApplicationStatus
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class InfoController constructor(
        private val applicationStatus: ApplicationStatus,
        private val infoConfiguration: InfoConfiguration
) {
    @GetMapping("version")
    fun getVersion(): ResponseEntity<String> {
        return ResponseEntity(infoConfiguration.buildVersion, HttpStatus.OK)
    }

    @GetMapping("status")
    fun getStatus(): ResponseEntity<String> {
        val httpStatus = applicationStatus.getHttpStatus()
        return ResponseEntity(httpStatus.name, httpStatus)
    }
}