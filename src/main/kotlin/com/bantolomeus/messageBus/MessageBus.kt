package com.bantolomeus.messageBus

import com.bantolomeus.model.ObserverInterface
import com.bantolomeus.model.SubscriptionEnum
import org.springframework.stereotype.Service

@Service
// private var observers: Map<SubscriptionEnum, ObserverInterface>,
class MessageBus {

    var observers: MutableList<ObserverInterface> = mutableListOf()

    fun update(message: SubscriptionEnum) {
        updateObservers(message)
    }

    fun updateObservers(message: SubscriptionEnum) {
        for (observer in observers) {
            observer.update(message)
        }
    }

    fun subscriptionIncoming(observer: ObserverInterface) {
        observers.add(observer)
    }

    fun unsubscribe(observer: ObserverInterface) {
        observers
                .filter { it == observer }
                .forEach { observers.remove(it) }
    }

}