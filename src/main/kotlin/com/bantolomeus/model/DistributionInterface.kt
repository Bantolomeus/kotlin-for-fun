package com.bantolomeus.model

import java.util.*

interface DistributionInterface {
    val distributionType: SubscriptionEnum

    fun createDistribution(range: Int, invocations: Long): Map<Int, Long> {
        val distribution = HashMap<Int, Long>()
        val random = Random()

        for (j in 0..invocations.minus(1)) {
            val randomNumber = getRandomNumber(random, range)

            distribution.put(randomNumber, (distribution as Map<Int, Long>).getOrDefault(randomNumber, 0L) + 1L)
        }
        return distribution
    }

    fun getProbability(range: Int, invocations: Long): Double {
        val factorOne = 1 / range.toDouble()
        val probability = Math.pow(factorOne, invocations.toDouble())

        return if (probability == 0.0) {
            Double.MIN_VALUE
        } else {
            probability
        }
    }

    fun getType(): SubscriptionEnum {
        return this.distributionType
    }

    fun getRandomNumber(random: Random, range: Int): Int
}