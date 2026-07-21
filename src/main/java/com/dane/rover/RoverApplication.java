package com.dane.rover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class RoverApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoverApplication.class, args);
    }

}
