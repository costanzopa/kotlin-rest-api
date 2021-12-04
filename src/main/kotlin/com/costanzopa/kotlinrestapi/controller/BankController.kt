package com.costanzopa.kotlinrestapi.controller

import com.costanzopa.kotlinrestapi.model.Bank
import com.costanzopa.kotlinrestapi.service.BankService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/banks")
class BankController(private val service: BankService) {

    @GetMapping
    fun getBanks(): Collection<Bank> = service.getAll()
}