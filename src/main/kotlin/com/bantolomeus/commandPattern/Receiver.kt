package com.bantolomeus.commandPattern

class Receiver {
    val commands = mutableListOf<String>()
    val numbers = mutableListOf<String>()

    fun chainCommand(command: String) {
        commands.add(command)
    }
}