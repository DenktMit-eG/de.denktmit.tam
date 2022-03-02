package de.denktmit.tam.webapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource("classpath:application-test.yaml")
class WebappApplicationIT {

	@Test
	void contextLoads() {
		assertThat("").isEqualTo("");
	}

}
