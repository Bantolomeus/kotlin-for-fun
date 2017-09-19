package com.bantolomeus.controller

import com.bantolomeus.service.CalculatorService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CalculatorController(private val calculatorService: CalculatorService) {

    @RequestMapping(path = arrayOf("/calculator"), method = arrayOf(RequestMethod.GET),
                    produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))

    fun getCalculatorData(
        @RequestParam(value = "input", required = true) input: String
    ): ResponseEntity<String> {

        calculatorService.addCommand(input)
        return ResponseEntity("last input: $input", HttpStatus.OK)
    }

    @RequestMapping(path = arrayOf("/calculator/execute"), method = arrayOf(RequestMethod.GET),
                    produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))

    fun getCalculatorData(): ResponseEntity<String> {
        return ResponseEntity(calculatorService.executeCommand(), HttpStatus.OK)
    }
}
