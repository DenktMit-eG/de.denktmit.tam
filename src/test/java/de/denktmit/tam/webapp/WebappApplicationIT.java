package de.denktmit.tam.webapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class WebappApplicationIT {

	@Test
	void contextLoads() {
		assertThat("").isEqualTo("");
	}

}
