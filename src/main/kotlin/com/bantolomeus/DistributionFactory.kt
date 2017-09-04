package com.bantolomeus

import com.bantolomeus.messageBus.MessageBus
import com.bantolomeus.model.DistributionInterface
import com.bantolomeus.model.NormalDistribution
import com.bantolomeus.model.SubscriptionEnum
import com.bantolomeus.model.UniformDistribution

class DistributionFactory(private val messageBus: MessageBus) {

    // make it static
    companion object {
        fun createDistribution(distribution: String): DistributionInterface {
            if (distribution == "uniform") {
                return UniformDistribution()
            } else {
                return NormalDistribution()
            }
        }
    }
}