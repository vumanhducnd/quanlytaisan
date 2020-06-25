package com.website.qlts;

import com.website.qlts.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class QltsApplication {

	public static void main(String[] args) {
		SpringApplication.run(QltsApplication.class, args);
	}

}
