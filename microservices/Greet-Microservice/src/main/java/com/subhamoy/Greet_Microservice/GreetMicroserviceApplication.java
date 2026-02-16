package com.subhamoy.Greet_Microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //for register in eureka server (Service-Registry)
public class GreetMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetMicroserviceApplication.class, args);
	}

}
