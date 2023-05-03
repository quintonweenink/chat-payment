package com.ximedes.paymentprovider

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TransactionService {

    private lateinit var transactionMapper: TransactionMapper

    @Autowired
    fun TransactionService(transactionMapper: TransactionMapper) {
        this.transactionMapper = transactionMapper;
    }

    fun getLastTransaction(): Transaction {
        return transactionMapper.getLastTransaction()
    }
}