package com.hdi.ruralbuscabff.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.hdi.ruralbuscabff.api"})
@EnableFeignClients
public class RuralBuscaBffApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(RuralBuscaBffApiApplication.class, args);
    }
}
