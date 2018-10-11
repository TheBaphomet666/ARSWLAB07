package com.parcial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()

public class StockExchangeApp {

    public static void main(String[] args) {

        SpringApplication.run(StockExchangeApp.class, args);
    }
}
