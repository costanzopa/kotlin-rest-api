package com.costanzopa.kotlinrestapi.controller


import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
internal class BankControllerTest @Autowired constructor(
    val mockMvc: MockMvc
) {

    val baseUrl = "/api/banks"


    @Nested
    @DisplayName("GET /api/banks")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetBanks {

        @Test
        fun `should return all banks`() {
            // when/then
            mockMvc.get(baseUrl)
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                }
        }
    }


    @Nested
    @DisplayName("GET /api/banks/{id}")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetBanksById {

        @Test
        fun `should the bank with the given account number`() {
            // given
            val accountNumber = 1234

            //act//assert
            mockMvc.get("$baseUrl/$accountNumber")
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$.trust") { value(3.14) }
                    jsonPath("$.transactionFee") { value(17) }
                }
        }

        @Test
        fun `should return NOT FOUND if the account number does not exists`() {
            // given
            val accountNumber = "does_not_exist"
            //act //assert
            mockMvc.get("$baseUrl/$accountNumber")
                .andDo { print() }
                .andExpect { status { isNotFound() } }
        }

    }


}