package com.example.ApplicationConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
@Import({SecurityConfig.class, SwaggerConfig.class})
@ComponentScan(basePackages = {"Rest","Model","Business","Repository","com.example.ApplicationConfig"})
@EntityScan(basePackages = {"model"})
@EnableJpaRepositories(basePackages = {"Repository"})
@EnableMongoRepositories(basePackages = {"Repository"})
@SpringBootApplication
public class ServiceModify {

    public static void main(String[] args) {
        SpringApplication.run(ServiceModify.class, args);
    }

}
