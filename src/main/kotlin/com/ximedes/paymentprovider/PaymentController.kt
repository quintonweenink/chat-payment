package com.ximedes.paymentprovider

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class PaymentController {

    @GetMapping("/helloWorld")
    fun helloWorld(): Transaction{

        Config.buildqlSessionFactory()?.openSession().use { session ->
            val mapper = session?.getMapper(TransactionMapper::class.java);

            return mapper?.getTransactions() ?: Transaction()
        }
    }
}