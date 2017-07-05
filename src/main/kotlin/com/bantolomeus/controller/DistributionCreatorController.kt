package com.bantolomeus.controller

import com.bantolomeus.model.DistributionCreatorModel
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RestController
class DistributionCreatorController {

    @RequestMapping(path = arrayOf("/getDistribution"), method = arrayOf(RequestMethod.GET), produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun getDistribution(
            @RequestParam(value = "rangeBegin", required = false, defaultValue = "0") rangeBegin: Int,
            @RequestParam(value = "rangeEnd", required = false, defaultValue = "9") rangeEnd: Int,
            @RequestParam(value = "range", required = false, defaultValue = "10") range: Int,
            @RequestParam(value = "invocations", required = false, defaultValue = "1000000") invocations: Long
    ): ResponseEntity<Map<String, Any>> {

        val distributionModel = DistributionCreatorModel()

        val response = mapOf( "distribution" to distributionModel.createDistribution(range, rangeBegin, rangeEnd, invocations))

//        return distributionModel.createDistribution(rangeBegin, invocations)
        return ResponseEntity(response, HttpStatus.OK)
    }

}
