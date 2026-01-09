package com.aayadi.cvingestion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.aayadi")
public class CvIngestionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CvIngestionServiceApplication.class, args);
    }

}
