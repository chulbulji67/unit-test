package com.example.unittest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloWroldController {
    @GetMapping("/hello-world")
    public String helloWorld(){
        log.info("Working");
        return "Hellow World";
    }
}
