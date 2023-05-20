package com.hongdatchy.ws;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WsApplication.class, args);
    }

    @Override
    public void run(String... args) {

    }
}
