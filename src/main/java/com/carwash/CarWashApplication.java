package com.carwash;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.carwash"})
public class CarWashApplication {
	
	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
	}

	
	public static void main(String[] args) {
		SpringApplication.run(CarWashApplication.class, args);
	}
	
}
