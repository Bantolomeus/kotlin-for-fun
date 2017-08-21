package com.bantolomeus.service

import com.bantolomeus.model.Statistic
import com.bantolomeus.model.UniformDistribution
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service



@Service
class StatisticService (private val statistic : Statistic){

    fun getUniformDistributionCalls(): Int{
        return statistic.uniformDistributionCounter
    }

    fun getNormalDistributionCalls(): Int{
        return statistic.normalDistributionCounter
    }

    fun uniformDistributionCalled() {
        statistic.uniformDistributionCalled()
    }

    fun normalDistributionCalled() {
        statistic.normalDistributionCalled()
    }

}