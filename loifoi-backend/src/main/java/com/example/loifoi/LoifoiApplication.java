package com.example.loifoi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LoifoiApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoifoiApplication.class, args);
    }
}
