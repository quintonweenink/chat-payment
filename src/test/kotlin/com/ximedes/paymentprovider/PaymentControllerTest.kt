package com.ximedes.paymentprovider

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class PaymentControllerTest {

    private var unit: PaymentController = PaymentController()

    @Test
    fun helloWorld() {
        assertEquals(unit.helloWorld(), "Hello World!");
    }
}