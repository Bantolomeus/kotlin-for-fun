package com.bantolomeus.controller

import com.bantolomeus.model.DistributionCreatorModel
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.HashMap

@RestController
class DistributionCreatorController {

    @RequestMapping(path = arrayOf("/fetch"), method = arrayOf(RequestMethod.GET), produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun fetchThemAll(@RequestParam(value = "range", required = false, defaultValue = "10") range: Int?): Int? {

        val randomNumberController = RandomNumberController()

        return randomNumberController.getRandomNumber(range)
    }

    @RequestMapping(path = arrayOf("/getDistribution"), method = arrayOf(RequestMethod.GET), produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun getDistribution(@RequestParam(value = "range", required = false, defaultValue = "10") range: Int,
                        @RequestParam(value = "invocations", required = false, defaultValue = "1000000") invocations: Long): Map<Int, Long> {

        val distributionModel = DistributionCreatorModel()

        return distributionModel.createDistribution(range, invocations)
    }

    private fun distributeTheNumbers(range: Int?, invocations: Long?): Map<Int, Long> {

        val distribution = HashMap<Int, Long>()

        val catchTheNumbers = DistributionCreatorController()

        for (j in 0..invocations!! - 1) {
            val retrievedNumber = catchTheNumbers.fetchThemAll(range)

            distribution.put(retrievedNumber!!, (distribution as Map<Int, Long>).getOrDefault(retrievedNumber, 0L) + 1L)
        }

        return distribution
    }
}
