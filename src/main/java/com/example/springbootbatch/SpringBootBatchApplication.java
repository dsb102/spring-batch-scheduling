package com.example.springbootbatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBatchApplication.class, args);
    }

}
