package com.yagizers.rentACar;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class RentACarApplication {
	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}

	//Spring'in ModelMapper sınıfını tanıyabilmesi adına Bean annotationı ile yeni bir ModelMapper create ediyoruz.
	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}
}
