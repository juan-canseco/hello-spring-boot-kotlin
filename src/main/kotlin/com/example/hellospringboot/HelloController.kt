package com.example.hellospringboot

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    @GetMapping("/hello")
    fun hello() : String  {
        return "hello"
    }

    @PostMapping("/greet")
    fun doGreeting(@RequestBody dto : GreetingDto) : ResponseEntity<String> {
        val message = "Hello ${dto.name}"
        return ResponseEntity.ok(message)
    }
}