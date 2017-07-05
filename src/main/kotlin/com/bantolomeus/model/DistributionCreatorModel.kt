package com.bantolomeus.model

import java.util.Random

open class DistributionCreatorModel {

    fun createDistribution(range: Int, invocations: Long): Map<Int, Long> {

        val distribution = HashMap<Int, Long>()
        val random = Random()

        for (j in 0..invocations - 1) {

            val randomNumber = random.nextInt(range)

            distribution.put(randomNumber, (distribution as Map<Int, Long>).getOrDefault(randomNumber, 0L) + 1L)
        }

        return distribution

//        return getDistributionWithRangeAndInvocations(range, invocations)
    }

    fun getProbability(range: Int, invocations: Long): Double {

//        val rangeAsDouble = range.toDouble()
//        val invocationsAsDouble = invocations.toDouble()

        val factorOne = 1/range.toDouble()
        val probability = Math.pow(factorOne, invocations.toDouble())

        return probability
    }
}