package com.shield.projectJavaCesi;

import com.shield.projectJavaCesi.controller.being.BeingController;
import com.shield.projectJavaCesi.controller.being.CivilController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@ComponentScan(basePackageClasses = {
//		CivilController.class
//})
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