// src/main/java/com/example/demo/Application.java
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {
    public String getMessage() {
        return "Hello, CI/CD Pipeline!";
    }

    @GetMapping("/")
    public String home() {
        return getMessage();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}