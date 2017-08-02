package com.bantolomeus.health

import org.springframework.context.ApplicationContext
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

import org.springframework.boot.actuate.health.HealthIndicator
import org.springframework.boot.actuate.health.Status


@Service
open class ApplicationStatus(
        private val applicationContext: ApplicationContext
) {

    fun getHttpStatus(): HttpStatus {
        try {
            applicationContext.getBeansOfType(HealthIndicator::class.java).forEach {
                if (it.value.health().status != Status.UP) {
                    return HttpStatus.SERVICE_UNAVAILABLE
                }
            }
        } catch (e: Exception) {
            return HttpStatus.SERVICE_UNAVAILABLE
        }
        return HttpStatus.OK
    }
}