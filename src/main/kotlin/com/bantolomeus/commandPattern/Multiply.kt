package com.bantolomeus.commandPattern

class Multiply(override val receiver: Receiver) : CommandInterface {

    override fun chain(input: String) {
        receiver.chain(input)
    }

    override fun execute(numbers: MutableList<Int>): Int {
        return numbers[0] * numbers[1]
    }
}