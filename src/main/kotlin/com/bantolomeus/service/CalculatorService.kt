package com.bantolomeus.service

import com.bantolomeus.commandPattern.CommandFactory
import com.bantolomeus.commandPattern.Receiver
import com.bantolomeus.model.Calculator
import org.springframework.stereotype.Service

@Service
class CalculatorService(private val calculator: Calculator, private val receiver: Receiver) {

    fun addCommand(command: String) {
        if (command == "+" || command == "-") {
            val concreteCommand = CommandFactory.createCommand(command, receiver)
            concreteCommand.chain(command)
        } else {
            receiver.numbers.add(command)
        }
    }

    fun executeCommand(): String {
        var result = ""
        if (receiver.numbers.size == 2) {
            for (command in receiver.commands) {
                if (command == "+") {
                    val intResult = receiver.numbers[0].toInt() + receiver.numbers[1].toInt()
                    result = intResult.toString()
                } else if(command == "-") {
                    val intResult = receiver.numbers[0].toInt() - receiver.numbers[1].toInt()
                    result = intResult.toString()
                }
            }
        } else {
            return "please provide two numbers and an operation(+ or -)"
        }
        return result
    }
}