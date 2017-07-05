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
    }

    fun getProbability(range: Int, invocations: Long): Double {

        val factorOne = 1/range.toDouble()
        val probability = Math.pow(factorOne, invocations.toDouble())

        if (probability == 0.0) {
            return Double.MIN_VALUE
        } else {
            return probability
        }
    }
}