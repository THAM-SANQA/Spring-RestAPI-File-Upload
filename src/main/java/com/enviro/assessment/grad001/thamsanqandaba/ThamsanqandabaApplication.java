package com.enviro.assessment.grad001.thamsanqandaba;

/**
 * @author thamsanqa 2024
 **/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.enviro.assessment.grad001.thamsanqandaba"})
@EnableJpaRepositories(basePackages = {"com.enviro.assessment.grad001.thamsanqandaba.repository"})
@EntityScan(basePackages = {"com.enviro.assessment.grad001.thamsanqandaba.model"})
public class ThamsanqandabaApplication {
	public static void main(String[] args) {
		SpringApplication.run(ThamsanqandabaApplication.class, args);
	}
}
