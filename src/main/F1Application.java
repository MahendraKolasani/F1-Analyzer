package main;

import main.Controller.DriverController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class F1Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(F1Application.class, args);
        DriverController obj = context.getBean(DriverController.class);
        obj.GetAll();
    }
}

