package com.costanzopa.kotlinrestapi.repository.impl

import com.costanzopa.kotlinrestapi.model.Bank
import com.costanzopa.kotlinrestapi.model.BankList
import com.costanzopa.kotlinrestapi.repository.BankRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import java.io.IOException

@Repository("network")
class BankNetworkRepository(@Autowired private val restTemplate: RestTemplate) : BankRepository {
    override fun getAll(): Collection<Bank> {
        val response: ResponseEntity<BankList> =
            restTemplate.getForEntity("http://54.193.31.159/banks")

        return response.body?.results
            ?: throw IOException("Could not fetch banks from the network")
    }

    override fun getById(accountNumber: String): Bank {
        TODO("Not yet implemented")
    }

    override fun create(bank: Bank): Bank {
        TODO("Not yet implemented")
    }

    override fun update(bank: Bank): Bank {
        TODO("Not yet implemented")
    }

    override fun deleteById(accountNumber: String) {
        TODO("Not yet implemented")
    }
}