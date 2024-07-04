package com.example.bootjpaex1;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"mycar.*","naver.storage","com.example.bootjpaex1"})
@EntityScan("mycar.data")
@EnableJpaRepositories("mycar.repository")
public class BootJpaEx1Application {

    public static void main(String[] args) {
        SpringApplication.run(BootJpaEx1Application.class, args);
    }

}
