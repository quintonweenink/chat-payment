package com.ximedes.paymentprovider

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

@Service
class TransactionService {

    var logger: Logger = LoggerFactory.getLogger(TransactionService::class.java)
    private lateinit var restTemplate: RestTemplate
    private lateinit var transactionMapper: TransactionMapper

    @Autowired
    fun TransactionService(transactionMapper: TransactionMapper, restTemplate: RestTemplate) {
        this.transactionMapper = transactionMapper
        this.restTemplate = restTemplate
    }

    fun getLastTransaction(): Transaction {
        val quote: String = restTemplate.getForObject(
                "https://www.google.com", String::class)
        logger.info(quote)

        return transactionMapper.getLastTransaction()


    }
}