package com.hdi.ruralbuscalbff.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.hdi.ruralbuscabff.api"})
public class RuralBuscaBffApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(RuralBuscaBffApiApplication.class, args);
    }
}
