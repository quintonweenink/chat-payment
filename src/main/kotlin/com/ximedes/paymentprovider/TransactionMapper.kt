package com.ximedes.paymentprovider

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface TransactionMapper {
    @Select("SELECT t.id, t.accountId, t.value FROM public.\"Transaction\" t limit 1")
    fun getLastTransaction(): Transaction;
}