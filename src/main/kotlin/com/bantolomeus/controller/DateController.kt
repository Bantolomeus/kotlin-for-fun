package com.bantolomeus.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


@RestController
class DateController {

        @RequestMapping("/date")
        fun getDate(): String {
            val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")
            val localDateTime = LocalDateTime.now()

            return dateTimeFormatter.format(localDateTime)
        }

}
