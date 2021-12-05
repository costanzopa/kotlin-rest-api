package com.costanzopa.kotlinrestapi.controller

import com.costanzopa.kotlinrestapi.model.Bank
import com.costanzopa.kotlinrestapi.service.BankService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/banks")
class BankController(private val service: BankService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun notFoundHandler(exception: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(exception.message, HttpStatus.NOT_FOUND)

    @GetMapping
    fun getBanks(): Collection<Bank> = service.getAll()

    @GetMapping("/{accountNumber}")
    fun getBankByAccountNumber(@PathVariable accountNumber: String): Bank =
        service.getById(accountNumber)
}