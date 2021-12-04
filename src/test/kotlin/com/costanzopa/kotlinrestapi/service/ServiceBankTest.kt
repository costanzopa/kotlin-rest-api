package com.costanzopa.kotlinrestapi.service

import com.costanzopa.kotlinrestapi.repository.impl.BankMockRepository
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

internal class BankServiceTest {

    private val dataSource: BankMockRepository = mockk(relaxed = true)

    private val bankService = BankService(dataSource)

    @Test
    fun `should call its data source to retrieve banks`() {
        // when
        bankService.getAll()

        // then
        verify(exactly = 1) { dataSource.getAll() }
    }
}