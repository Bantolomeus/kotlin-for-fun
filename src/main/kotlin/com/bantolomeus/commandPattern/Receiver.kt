package com.bantolomeus.commandPattern

import org.springframework.stereotype.Service

@Service
class Receiver {
    var commands = mutableListOf<String>()

    fun chain(command: String) {
        commands.add(command)
    }
}