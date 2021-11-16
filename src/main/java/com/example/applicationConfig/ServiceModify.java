package com.example.applicationConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"Model"})
@EnableJpaRepositories(basePackages = {"repository"})
@EnableMongoRepositories(basePackages = {"repository"})
@ComponentScan(basePackages = {"rest", "Model", "business", "repository", "com.example.applicationConfig", "Util"})
public class ServiceModify {

    public static void main(String[] args) {
        SpringApplication.run(ServiceModify.class, args);
    }

}
