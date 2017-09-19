package com.bantolomeus.service

import com.bantolomeus.model.Calculator
import org.springframework.stereotype.Service

@Service
class CalculatorService(private val calculator: Calculator) {

    fun addCommand(command: String) {
        calculator.command.add(command)
    }

    // implement logic for processing
    fun executeCommand(): String {
        val string = StringBuilder()
        for (entry in calculator.command) {
            string.append(entry)
        }
        return string.toString()
    }
}