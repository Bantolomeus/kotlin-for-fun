package com.bantolomeus.commandPattern

class Multiply(private val receiver: Receiver) : CommandInterface {

    override fun chain(command: String) {
        receiver.chainCommand(command)
    }
}