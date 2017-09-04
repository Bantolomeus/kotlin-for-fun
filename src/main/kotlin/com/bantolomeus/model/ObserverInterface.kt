package com.bantolomeus.model

interface ObserverInterface {
    // subscribe and unsubscribe directly at messageBus
    fun unsubscribe(observer: ObserverInterface)

    fun subscribe(observer: ObserverInterface)

    fun update(message: SubscriptionEnum)

}