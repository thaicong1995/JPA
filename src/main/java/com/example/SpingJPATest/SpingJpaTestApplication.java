package com.example.SpingJPATest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
//@EnableJpaRepositories("com.example.SpingJPATest.Reposi")
@ComponentScan("com.example.SpingJPATest.Reposi")
public class SpingJpaTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpingJpaTestApplication.class, args);
	}

}
