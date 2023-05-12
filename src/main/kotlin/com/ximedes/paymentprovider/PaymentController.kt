package com.ximedes.paymentprovider

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PaymentController(@Autowired transactionServicef: TransactionService) {

    private final var transactionService: TransactionService
    init {
        transactionService = transactionServicef;
    }

    @GetMapping("/getLastTransaction")
    suspend fun getLastTransaction(): Transaction = transactionService.getLastTransaction()
}