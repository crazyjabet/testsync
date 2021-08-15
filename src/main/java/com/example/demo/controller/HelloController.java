package com.example.demo.controller;

import com.example.demo.model.Health;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/health")
    public String greeting() {
        return new Health().getHealthCheckPass();
    }

}
