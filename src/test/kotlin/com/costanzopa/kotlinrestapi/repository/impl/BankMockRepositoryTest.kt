package com.costanzopa.kotlinrestapi.repository.impl

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BankMockRepositoryTest {

    private val bankMockRepository = BankMockRepository()

    @Test
    fun `should provide a collection of banks`() {

        //act
        val banks = bankMockRepository.getAll()

        //assert
        assertThat(banks).isNotEmpty
    }

    @Test
    fun `should provide some bank data`() {
        //act
        val banks = bankMockRepository.getAll()

        //assert
        assertThat(banks).allMatch { it.accountNumber.isNotBlank() }

    }

}

