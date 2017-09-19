package com.bantolomeus.commandPattern

import org.springframework.stereotype.Service

@Service
class Receiver {
    var commands = mutableListOf<String>()
    var numbers = mutableListOf<String>()

    fun chainCommand(command: String) {
        commands.add(command)
    }
}