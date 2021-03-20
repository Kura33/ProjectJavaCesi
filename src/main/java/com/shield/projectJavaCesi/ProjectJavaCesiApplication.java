package com.shield.projectJavaCesi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.annotation.JsonInclude;

@SpringBootApplication
public class ProjectJavaCesiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectJavaCesiApplication.class, args);
	}
	//don't add data to Json when the data is null.
	@Bean
	public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
	    return builder -> builder.serializationInclusion(JsonInclude.Include.NON_NULL);
	}

}
