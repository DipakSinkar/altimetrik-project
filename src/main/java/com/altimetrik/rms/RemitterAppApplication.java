package com.altimetrik.rms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RemitterAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RemitterAppApplication.class, args);
		System.out.println("Running fine");
	}

}
