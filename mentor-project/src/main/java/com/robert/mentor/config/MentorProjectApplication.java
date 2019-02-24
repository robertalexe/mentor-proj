package com.robert.mentor.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ComponentScan( basePackages = {"com.robert.mentor"})
@EnableTransactionManagement
@EnableJpaRepositories("com.robert.mentor")
@EntityScan(basePackages = {"com.robert.mentor"})
public class MentorProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MentorProjectApplication.class, args);
	}

}

