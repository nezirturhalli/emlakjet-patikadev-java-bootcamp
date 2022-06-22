package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Week4Assignment4Application {

    public static void main(String[] args) {
        SpringApplication.run(Week4Assignment4Application.class, args);
    }

}
