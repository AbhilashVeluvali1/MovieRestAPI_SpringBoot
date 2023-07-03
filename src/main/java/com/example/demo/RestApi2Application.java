package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EnableAutoConfiguration
@SpringBootApplication
public class RestApi2Application {

	public static void main(String[] args) {
		SpringApplication.run(RestApi2Application.class, args);
	}

}
