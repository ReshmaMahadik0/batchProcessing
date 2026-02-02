package com.example.BatchProcessing_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BatchProcessingAppApplication {

	public static void main(String[] args) {
		System.exit(
				SpringApplication.exit(
						SpringApplication.run(BatchProcessingAppApplication.class, args)
				)
		);
	}
}
