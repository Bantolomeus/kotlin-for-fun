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
}