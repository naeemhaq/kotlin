package ca.canada.ssc.demo.controllers

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping

@RestController
class HelloController {

    @GetMapping("/hello")
    fun handle(): String {
        return "Hello WebFlux"
    }

}
