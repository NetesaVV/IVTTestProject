package ru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("web.controllers")
@ComponentScan("ru.core.services")
@SpringBootApplication()

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
