package com.bantolomeus.controller

import com.bantolomeus.service.StatisticService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class StatisticController (private val statisticService: StatisticService) {
    @RequestMapping(path = arrayOf("/statistic"), method = arrayOf(RequestMethod.GET), produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun getDistribution(): ResponseEntity<Map<String, Any>> {

        val response = mapOf("normal distribution called" to statisticService.getNormalDistributionCalls(),
                "uniform distribution called" to statisticService.getUniformDistributionCalls())

        return ResponseEntity(response, HttpStatus.OK)
    }
// , method = arrayOf(RequestMethod.GET), produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(path = arrayOf("/statistic/subscribe"))
    fun setSubscription() {
        statisticService.subscribe(statisticService)
    }
}