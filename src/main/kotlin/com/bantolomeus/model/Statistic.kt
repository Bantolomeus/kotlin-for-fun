package com.bantolomeus.model

import org.springframework.stereotype.Service

@Service
class Statistic {
    final var normalDistributionCounter: Int
    final var uniformDistributionCounter: Int

    init {
        normalDistributionCounter = 0
        uniformDistributionCounter = 0
    }

    fun normalDistributionCalled() {
        normalDistributionCounter++
    }

    fun uniformDistributionCalled() {
        uniformDistributionCounter++
    }

}
