package com.bantolomeus.controller

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class RollController {

    @RequestMapping(path = arrayOf("/rollNames"), method = arrayOf(RequestMethod.GET), produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun getRandomMapping(
            @RequestParam(value = "names", required = false, defaultValue = "") names: String
    ): ResponseEntity<String> {

        val namesSeparated = names.split(",")

        return ResponseEntity(namesSeparated[Random().nextInt(namesSeparated.size)], HttpStatus.OK)
//        return ResponseEntity(names, HttpStatus.OK)
    }
}