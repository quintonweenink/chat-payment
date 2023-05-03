package com.ximedes.paymentprovider

import org.apache.ibatis.datasource.pooled.PooledDataSource
import org.apache.ibatis.mapping.Environment
import org.apache.ibatis.session.Configuration
import org.apache.ibatis.session.SqlSessionFactory
import org.apache.ibatis.session.SqlSessionFactoryBuilder
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory
import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate
import javax.sql.DataSource


@org.springframework.context.annotation.Configuration
@MapperScan("com.ximedes")
class Config {


    val DRIVER = "org.postgresql.Driver"
    val URL = "jdbc:postgresql://localhost:5432/postgres"
    val USERNAME = "postgres"
    val PASSWORD = "ThisIsATest@1"

    @Bean
    fun buildqlSessionFactory(): SqlSessionFactory? {
        val dataSource: DataSource = PooledDataSource(DRIVER, URL, USERNAME, PASSWORD)
        val environment =
                Environment("Development", JdbcTransactionFactory(), dataSource)
        val configuration =
                Configuration(environment)
        configuration.addMapper(TransactionMapper::class.java)
        val builder = SqlSessionFactoryBuilder()
        return builder.build(configuration)
    }

    @Bean
    fun restTemplate(builder: RestTemplateBuilder): RestTemplate? {
        return builder.build()
    }
}