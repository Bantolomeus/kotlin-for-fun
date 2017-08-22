package com.bantolomeus.messageBus

import com.bantolomeus.model.ObserverInterface
import com.bantolomeus.model.SubscriptionEnum
import com.bantolomeus.service.StatisticService
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
// private var observers: Map<SubscriptionEnum, ObserverInterface>,
class MessageBus(private val statisticService: StatisticService) {

    fun update(message: SubscriptionEnum) {
        updateObservers(message)
    }

    fun updateObservers(message: SubscriptionEnum) {
//        for ((subscription, observer) in observers) {
            if (message == SubscriptionEnum.NORMAL_DISTRIBUTION) {
                statisticService.normalDistributionCalled()
            } else if (message == SubscriptionEnum.UNIFORM_DISTRIBUTION) {
                statisticService.uniformDistributionCalled()
            }
//        }
    }

}