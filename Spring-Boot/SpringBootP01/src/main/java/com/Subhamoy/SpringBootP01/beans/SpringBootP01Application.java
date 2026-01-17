package com.Subhamoy.SpringBootP01.beans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class SpringBootP01Application {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootP01Application.class, args);
		// shortcut key - ctrl+ alt+v
		//Internally activate IOC container
		Car bean = context.getBean(Car.class);
		bean.m1();
	}
}


