package com.fdm.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class MastersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MastersApplication.class, args);
	}

}
