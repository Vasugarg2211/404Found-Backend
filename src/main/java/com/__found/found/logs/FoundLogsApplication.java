package com.__found.found.logs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoundLogsApplication {

	public static void main(String[] args) {
		System.out.println("Log Application");
		SpringApplication.run(FoundLogsApplication.class, args);
	}

}
