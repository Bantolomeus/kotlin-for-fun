package com.bantolomeus.controller

import com.bantolomeus.model.DistributionInterface
import com.bantolomeus.model.NormalDistribution
import com.bantolomeus.model.UniformDistribution
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class DistributionCreatorController {

    @RequestMapping(path = arrayOf("/getDistribution"), method = arrayOf(RequestMethod.GET), produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun getDistribution(
            @RequestParam(value = "distribution", required = false, defaultValue = "normal") distribution: String,
            @RequestParam(value = "rangeBegin", required = false, defaultValue = "0") rangeBegin: Int,
            @RequestParam(value = "rangeEnd", required = false, defaultValue = "9") rangeEnd: Int,
            @RequestParam(value = "range", required = false, defaultValue = "10") range: Int,
            @RequestParam(value = "invocations", required = false, defaultValue = "1000000") invocations: Long
    ): ResponseEntity<Map<String, Any>> {

        val rangeCalculated = calculateRange(range, rangeBegin, rangeEnd, invocations)

        val distributionModel: DistributionInterface = if (distribution == "uniform") {
            UniformDistribution()
        } else {
            NormalDistribution()
        }

        val response = mapOf("distribution" to distributionModel.createDistribution(rangeCalculated, invocations),
                "probability" to distributionModel.getProbability(rangeCalculated, invocations))

        return ResponseEntity(response, HttpStatus.OK)
    }

    fun calculateRange(range: Int, rangeBegin: Int, rangeEnd: Int, invocations: Long): Int {

        return if ((rangeBegin != 0 || rangeEnd != 9) && rangeEnd > rangeBegin) {
            rangeEnd - rangeBegin
        } else {
            range
        }
    }

}
