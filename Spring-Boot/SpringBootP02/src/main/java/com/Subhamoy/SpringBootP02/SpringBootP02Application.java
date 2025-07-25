package com.Subhamoy.SpringBootP02;

import com.Subhamoy.SpringBootP02.beans.Instagram;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootP02Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootP02Application.class, args);
		Instagram bean = context.getBean(Instagram.class);
		bean.play();
	}

}
