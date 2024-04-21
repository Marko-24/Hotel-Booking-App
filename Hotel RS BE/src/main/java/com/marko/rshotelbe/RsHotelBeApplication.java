package com.marko.rshotelbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class RsHotelBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(RsHotelBeApplication.class, args);
    }

}

// @SpringBootApplication(exclude = {SecurityAutoConfiguration.class}) za da ne kreira avtomatski pasvord