package com.project.moneymanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class MoneymanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoneymanagerApplication.class, args);
    }
    @RequestMapping("/")
    // 3. Method that maps to the request route above
    public String hello() { // 3
        return "Hello World!";
    }

}
