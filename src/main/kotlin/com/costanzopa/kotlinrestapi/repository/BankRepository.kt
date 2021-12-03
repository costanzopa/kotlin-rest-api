package com.costanzopa.kotlinrestapi.repository

import com.costanzopa.kotlinrestapi.model.Bank

interface BankRepository {

    fun retrieveBanks(): Collection<Bank>

    fun retrieveBank(accountNumber: String): Bank

    fun createBank(bank: Bank): Bank

    fun updateBank(bank: Bank): Bank

    fun deleteBank(accountNumber: String)
}