package com.ximedes.paymentprovider

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class PaymentControllerTest {

    private val transactionService = mock(TransactionService::class.java)
    private var unit = PaymentController(transactionService)


    @Test
    fun getLastTransaction() {
        `when`(transactionService.getLastTransaction()).then {Transaction()}

        val transaction = unit.getLastTransaction()

        assertEquals(transaction.value, Long.MAX_VALUE);
    }
}