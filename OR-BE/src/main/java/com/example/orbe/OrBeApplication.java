package com.example.orbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class OrBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrBeApplication.class, args);
    }

}
