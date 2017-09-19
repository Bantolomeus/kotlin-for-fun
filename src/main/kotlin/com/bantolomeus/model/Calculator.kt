package com.bantolomeus.model

import org.springframework.stereotype.Service

@Service
class Calculator {
    final var command: MutableList<String> = mutableListOf()
}