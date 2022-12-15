# Hello Spring Boot With Kotlin


## HelloController
```java
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
```

## Tests
```java
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
```
