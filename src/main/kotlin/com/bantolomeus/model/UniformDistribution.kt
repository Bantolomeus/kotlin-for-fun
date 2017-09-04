package com.bantolomeus.model

import java.util.*

class UniformDistribution : DistributionInterface {
    override val distributionType = SubscriptionEnum.UNIFORM_DISTRIBUTION

    override fun getRandomNumber(random: Random, range: Int): Int {
        return random.nextInt(range)
    }
}