package com.bantolomeus.commandPattern

class Number(override val receiver: Receiver) : CommandInterface {

    override fun chain(input: String) {
        receiver.chain(input)
    }

    override fun execute(numbers: MutableList<Int>): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}