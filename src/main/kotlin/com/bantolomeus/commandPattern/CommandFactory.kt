package com.bantolomeus.commandPattern

class CommandFactory() {

    companion object {
        fun createCommand(command: String, receiver: Receiver): CommandInterface {
            return when (command) {
                "+" -> Summation(receiver)
                "-" -> Minus(receiver)
                "*" -> Multiply(receiver)
                else -> Number(receiver)
            }
        }
    }
}