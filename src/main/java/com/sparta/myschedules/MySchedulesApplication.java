package com.sparta.myschedules;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MySchedulesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySchedulesApplication.class, args);
    }

}
