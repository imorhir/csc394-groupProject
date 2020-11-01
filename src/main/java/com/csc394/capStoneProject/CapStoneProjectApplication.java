package com.csc394.capStoneProject;

import com.csc394.capStoneProject.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class CapStoneProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapStoneProjectApplication.class, args);
	}

}
