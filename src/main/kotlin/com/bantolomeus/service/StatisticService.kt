package com.bantolomeus.service

import com.bantolomeus.model.ObserverInterface
import com.bantolomeus.model.Statistic
import org.springframework.stereotype.Service

@Service
class StatisticService (private val statistic : Statistic): ObserverInterface {

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