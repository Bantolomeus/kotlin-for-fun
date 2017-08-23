package com.bantolomeus.service

import com.bantolomeus.messageBus.MessageBus
import com.bantolomeus.model.ObserverInterface
import com.bantolomeus.model.Statistic
import com.bantolomeus.model.SubscriptionEnum
import org.springframework.stereotype.Service

@Service
class StatisticService (private val statistic : Statistic, private val messageBus: MessageBus): ObserverInterface {

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

    override fun subscribe(observer: ObserverInterface) {
        messageBus.subscriptionIncoming(observer)
    }

    override fun unsubscribe(observer: ObserverInterface) {
        messageBus.unsubscribe(observer)
    }

    override fun update(message: SubscriptionEnum) {
        if (message == SubscriptionEnum.UNIFORM_DISTRIBUTION) {
            uniformDistributionCalled()
        } else {
            normalDistributionCalled()
        }
    }
}

/*
messagebus.update > statisticService.update > statistic.distributionCalled > distribution++
 */