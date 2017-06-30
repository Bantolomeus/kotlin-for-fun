package com.bantolomeus.controller

import com.bantolomeus.model.DistributionCreatorModel
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class DistributionCreatorController {

    @RequestMapping(path = arrayOf("/getDistribution"), method = arrayOf(RequestMethod.GET), produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun getDistribution(@RequestParam(value = "range", required = false, defaultValue = "10") range: Int,
                        @RequestParam(value = "invocations", required = false, defaultValue = "1000000") invocations: Long): Map<Int, Long> {

        val distributionModel = DistributionCreatorModel()

        return distributionModel.createDistribution(range, invocations)
    }

}
