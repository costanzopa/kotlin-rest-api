package com.costanzopa.kotlinrestapi.repository

import com.costanzopa.kotlinrestapi.model.Bank

interface BankRepository {

    fun getAll(): Collection<Bank>

    fun getById(accountNumber: String): Bank

    fun create(bank: Bank): Bank

    fun update(bank: Bank): Bank

    fun deleteById(accountNumber: String)
}