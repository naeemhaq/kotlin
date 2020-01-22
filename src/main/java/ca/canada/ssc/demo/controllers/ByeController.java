package ca.canada.ssc.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ByeController {

    private String Name = "John Doe";

    @GetMapping("/bye")
    public String handle() {
        return "Hello WebFlux";
    }

}
