package com.springdonjon.donjonanddragonjava;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping
    public String helloWorld(){
        return "Hello world from Spring Boot";
    }

        @RequestMapping("/goodbye")
    public String goodbye(){
        return "Good bye from Spring Boot";
    }
}
