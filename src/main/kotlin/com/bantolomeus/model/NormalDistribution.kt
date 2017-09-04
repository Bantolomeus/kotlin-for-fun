package com.bantolomeus.model

import java.util.*

class NormalDistribution : DistributionInterface {
    override val distributionType = SubscriptionEnum.NORMAL_DISTRIBUTION

    override fun getRandomNumber(random: Random, range: Int): Int {
        return random.nextGaussian().toInt() * range
    }
}