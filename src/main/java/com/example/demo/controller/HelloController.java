package com.example.demo.controller;

import com.example.demo.model.Health;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @GetMapping("/health")
    public String greeting() {
        log.info("hello");
        System.err.println("====== Error hello ======");
        return new Health().getHealthCheckPass();
    }

}
