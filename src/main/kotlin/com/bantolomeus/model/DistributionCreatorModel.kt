package com.bantolomeus.model

import java.util.Random

open class DistributionCreatorModel {

    fun createDistribution(range: Int, rangeBegin: Int, rangeEnd: Int, invocations: Long): Map<Int, Long> {

        if ((rangeBegin != 0 || rangeEnd != 9) && rangeEnd > rangeBegin) {
            val rangeCalculated = rangeEnd - rangeBegin

            return getDistributionWithRangeAndInvocations(rangeCalculated, invocations)
        } else {
            return getDistributionWithRangeAndInvocations(range, invocations)
        }

    }

    fun getDistributionWithRangeAndInvocations(range: Int, invocations: Long): HashMap<Int, Long> {

        val distributionToCreate = HashMap<Int, Long>()
        val random = Random()

        for (j in 0..invocations - 1) {

            val randomNumber = random.nextInt(range)

            distributionToCreate.put(randomNumber, (distributionToCreate as Map<Int, Long>).getOrDefault(randomNumber, 0L) + 1L)
        }

        return distributionToCreate
    }
}