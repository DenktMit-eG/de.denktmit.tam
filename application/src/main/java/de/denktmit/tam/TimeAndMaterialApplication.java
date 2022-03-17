package de.denktmit.tam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "de.denktmit.tam")
public class TimeAndMaterialApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimeAndMaterialApplication.class, args);
	}

}
