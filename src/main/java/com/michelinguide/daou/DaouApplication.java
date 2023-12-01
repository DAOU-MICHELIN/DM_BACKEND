package com.michelinguide.daou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DaouApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaouApplication.class, args);
	}

}
