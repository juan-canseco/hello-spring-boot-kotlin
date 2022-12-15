package com.example.hellospringboot

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
class HelloControllerTests {


    @Autowired
    lateinit var mockMvc : MockMvc

    @Autowired
    lateinit var mapper : ObjectMapper

    @Test
    fun `get hello should return 200`() {
        val request = MockMvcRequestBuilders
            .get("/hello")
            .contentType(MediaType.APPLICATION_JSON)

        mockMvc.perform(request)
            .andExpect(status().isOk)

    }

    @Test
    fun `greet should return 200`() {
        val greetingDto = GreetingDto(
            "Juan Pablo"
        )

        val request = MockMvcRequestBuilders
            .post("/greet")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(greetingDto))

        mockMvc.perform(request)
            .andExpect(status().isOk)
    }
}