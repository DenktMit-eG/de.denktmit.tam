package de.denktmit.tam.springconfig;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootConfiguration
@EnableJpaRepositories("de.denktmit.tam.persistence")
public class PersistenceConfig {

}
