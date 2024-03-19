package com.example.demo.car;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(CarRepository repository) {
		return args -> {	
			Car lambo = new Car("lambo", "aventador", "super", 2, 2000000);
			repository.saveAll(List.of(lambo));
		};
	}

}
