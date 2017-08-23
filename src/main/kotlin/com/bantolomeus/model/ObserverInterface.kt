package com.bantolomeus.model

interface ObserverInterface {

    fun unsubscribe(observer: ObserverInterface)

    fun subscribe(observer: ObserverInterface)

    fun update(message: SubscriptionEnum)

}