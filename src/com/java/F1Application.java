package com.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class F1Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(F1Application.class, args);
        Usecase1 obj = context.getBean(Usecase1.class);
        obj.main();
    }
}

