package com.bantolomeus.commandPattern

interface CommandInterface {

    val receiver: Receiver

    fun chain(input: String) {
        receiver.chain(input)
    }

    fun execute(numbers: MutableList<Int>): Int
}