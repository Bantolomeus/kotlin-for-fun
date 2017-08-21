package com.bantolomeus.model

class Statistic {
    var normalDistributionCounter: Int = 0
    var uniformDistributionCounter: Int = 0

    fun normalDistributionCalled() {
        normalDistributionCounter.inc()
    }

    fun uniformDistributionCalled() {
        uniformDistributionCounter.inc()
    }

}
