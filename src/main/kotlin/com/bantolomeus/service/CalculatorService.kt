package com.bantolomeus.service

import com.bantolomeus.commandPattern.CommandFactory
import com.bantolomeus.commandPattern.Receiver
import org.springframework.stereotype.Service

@Service
class CalculatorService(private val receiver: Receiver) {

    fun addCommand(command: String) {
            val concreteCommand = CommandFactory.createCommand(command, receiver)
            concreteCommand.chain(command)
    }

    fun executeCommand(): String {
        var result = "Please provide two numbers and one command(+, -, *)"
        val numbers = mutableListOf<Int>()

        for (command in receiver.commands) {
            val numberOrNot = checkForNumber(command)

            if (numberOrNot.containsKey(true)) {
                numbers.add(numberOrNot.getValue(true))
            }
        }

        if (numbers.size == 2) {
            for (command in receiver.commands) {
                if (checkForNumber(command).containsKey(false)) {
                    result = CommandFactory.createCommand(command, receiver).execute(numbers).toString()
                }
            }
        } else {
            emptyCommands()
            return result
        }

        emptyCommands()
        return result
    }

    private fun checkForNumber(command: String): MutableMap<Boolean, Int> {
        return try {
            command.toInt()
            mutableMapOf(true to command.toInt() )
        } catch (e: NumberFormatException) {
            mutableMapOf(false to 0)
        }
    }

    private fun emptyCommands() {
        receiver.commands = mutableListOf()
    }
}