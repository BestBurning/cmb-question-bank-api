package com.di1shuai.questionbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CmbQuestionBankApiApplication {

	@GetMapping(path = "/hello")
	public String hello(){
		return "hello world";
	}


	public static void main(String[] args) {
		SpringApplication.run(CmbQuestionBankApiApplication.class, args);
	}

}
