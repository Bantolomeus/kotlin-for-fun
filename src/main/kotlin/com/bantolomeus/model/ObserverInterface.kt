package com.bantolomeus.model

interface ObserverInterface {

    // implement unsubscribe


    fun subscribe(observer: ObserverInterface)

//    fun update

    fun update(message: SubscriptionEnum)

}