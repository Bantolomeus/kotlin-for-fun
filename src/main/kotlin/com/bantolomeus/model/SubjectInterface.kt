package com.bantolomeus.model

import com.bantolomeus.messageBus.MessageBus

interface SubjectInterface {

    fun sendUpdate(updateMessage: SubscriptionEnum)
}