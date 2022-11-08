package com.javatechie.spring.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
public class BatchProcessingDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchProcessingDemoApplication.class, args);
	}

}
