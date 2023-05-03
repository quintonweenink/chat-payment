package com.ximedes.paymentprovider

import org.apache.ibatis.datasource.pooled.PooledDataSource
import org.apache.ibatis.mapping.Environment
import org.apache.ibatis.session.Configuration
import org.apache.ibatis.session.SqlSessionFactory
import org.apache.ibatis.session.SqlSessionFactoryBuilder
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory
import javax.sql.DataSource


class Config {



    companion object {
        val DRIVER = "org.postgresql.Driver"
        val URL = "jdbc:postgresql://localhost:5432/postgres"
        val USERNAME = "postgres"
        val PASSWORD = "ThisIsATest@1"

    fun buildqlSessionFactory(): SqlSessionFactory? {
        val dataSource: DataSource = PooledDataSource(DRIVER, URL, USERNAME, PASSWORD)
        val environment =
            Environment("Development", JdbcTransactionFactory(), dataSource)
        val configuration =
            Configuration(environment)
        configuration.addMapper(TransactionMapper::class.java)
        val builder = SqlSessionFactoryBuilder()
        return builder.build(configuration)
    }}
}