package com.bantolomeus.controller

import com.bantolomeus.model.DistributionCreatorModel
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

        /*
        distribution parameter
        gauss and standard distribution implementation
        distribution interface

        im code:
         variable from type distribution interface

         if parameter = gauss then gauss.distribution.impl

         same for standard

         execute getDistribution on interface variable
         */

        val rangeCalculated = calculateRange(range, rangeBegin, rangeEnd, invocations)
        val distributionModel: DistributionInterface

        if (distribution == "uniform") {
            distributionModel = UniformDistribution()
        } else {
            distributionModel = NormalDistribution()
        }

        val response = mapOf("distribution" to distributionModel.createDistribution(rangeCalculated, invocations),
                "probability" to distributionModel.getProbability(rangeCalculated, invocations))

        return ResponseEntity(response, HttpStatus.OK)
    }

    fun calculateRange(range: Int, rangeBegin: Int, rangeEnd: Int, invocations: Long): Int {

        if ((rangeBegin != 0 || rangeEnd != 9) && rangeEnd > rangeBegin) {

            return rangeEnd - rangeBegin
        } else {

            return range
        }
    }

}
