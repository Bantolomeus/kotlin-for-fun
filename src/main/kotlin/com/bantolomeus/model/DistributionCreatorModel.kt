package com.bantolomeus.model

import com.bantolomeus.controller.DistributionCreatorController
import java.util.HashMap

open class DistributionCreatorModel {

    fun createDistribution(range: Int, invocations: Long): Map<Int, Long> {

        val distribution = HashMap<Int, Long>()

        val catchTheNumbers = DistributionCreatorController()

        for (j in 0..invocations - 1) {
            val retrievedNumber = catchTheNumbers.fetchThemAll(range)

            // TODO: remove this
            distribution.put(retrievedNumber!!, (distribution as Map<Int, Long>).getOrDefault(retrievedNumber, 0L) + 1L)
        }

        return distribution
    }
}