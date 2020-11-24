package com.di1shuai.questionbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableElasticsearchRepositories(basePackages = "com.di1shuai.questionbank.repository")
@SpringBootApplication
public class CmbQuestionBankApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmbQuestionBankApiApplication.class, args);
	}

}
