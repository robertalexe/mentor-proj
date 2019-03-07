package com.robert.mentor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MentorProjectEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MentorProjectEurekaApplication.class, args);
	}

}
