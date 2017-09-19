package com.bantolomeus.commandPattern

class Summation(private val receiver: Receiver) : CommandInterface {

    override fun chain(command: String) {
        receiver.chainCommand(command)
    }
}