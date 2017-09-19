package com.bantolomeus.commandPattern

class Minus(private val receiver: Receiver) : CommandInterface {

    override fun chain(command: String) {
        receiver.chainCommand(command)
    }
}