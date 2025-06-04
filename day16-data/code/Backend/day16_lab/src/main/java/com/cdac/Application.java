package com.cdac;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication 
// => it contains @Configuration -for declaring java config class
//can add @Bean methods - to declare 3rd party beans
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	/*
	 * add @Bean method to declare spring bean
	 *  - so that SC can manage its life cycle
	 *  - can be injected as dependency in other spring beans
	 */
	@Bean //singleton n eager spring bean
	 ModelMapper modelMapper() {
		System.out.println("creating model mapper");
		//later we will configure ModelMapper bean ....
		return new ModelMapper();
	}

}
