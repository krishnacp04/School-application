package com.school.bachpan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = "com.school.bachpan")
@EnableSwagger2
public class BachpanApplication {

	public static void main(String[] args) {
		SpringApplication.run(BachpanApplication.class, args);
	}

}
