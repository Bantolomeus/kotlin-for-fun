package com.bantolomeus.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class RandomNumberController {

    @RequestMapping(path = arrayOf("/random"), method = arrayOf(RequestMethod.GET), produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun getRandomNumber(@RequestParam(value = "range", required = false, defaultValue = "10") range: Int?): Int? {
        val random = Random()
        return random.nextInt(range!!)
    }

}
