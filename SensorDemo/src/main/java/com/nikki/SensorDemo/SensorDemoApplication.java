package com.nikki.SensorDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.nikki")
public class SensorDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SensorDemoApplication.class, args);
	}

}
