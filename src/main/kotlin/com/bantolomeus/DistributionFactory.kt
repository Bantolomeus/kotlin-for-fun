package com.bantolomeus

import com.bantolomeus.model.DistributionInterface
import com.bantolomeus.model.NormalDistribution
import com.bantolomeus.model.UniformDistribution

class DistributionFactory {

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