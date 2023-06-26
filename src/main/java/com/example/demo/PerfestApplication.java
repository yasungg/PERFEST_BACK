package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EntityScan("com.example.demo.entity")
public class PerfestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PerfestApplication.class, args);
	}

}
