package com.bantolomeus.model

import java.util.*

class UniformDistribution : DistributionInterface {

    override fun getRandomNumber(random: Random, range: Int): Int {
        return random.nextInt(range)
    }
}