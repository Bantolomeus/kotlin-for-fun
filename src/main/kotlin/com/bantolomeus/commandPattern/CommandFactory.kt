package com.bantolomeus.commandPattern

class CommandFactory() {

    companion object {
        fun createCommand(command: String, receiver: Receiver): CommandInterface {
            if (command == "+") {
                return Summation(receiver)
            } else {
                return Minus(receiver)
            }
        }
    }
}