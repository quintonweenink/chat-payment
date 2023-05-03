package com.ximedes.paymentprovider

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PaymentController {

    private lateinit var transactionService: TransactionService

    @Autowired
    fun PaymentController(transactionService: TransactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/getLastTransaction")
    fun getLastTransaction(): Transaction {

        return transactionService.getLastTransaction()
    }
}