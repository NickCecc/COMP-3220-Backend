package com.example.my_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * The main entry point for the MyBackend Spring Boot application.
 *
 * This class is responsible for bootstrapping and launching the application.
 */
@SpringBootApplication
public class MyBackendApplication {
	/**
	 * The main method that starts the Spring Boot application.
	 *
	 * @param args command-line arguments passed to the application
	 */
	public static void main(String[] args) {
		SpringApplication.run(MyBackendApplication.class, args);
	}

}
