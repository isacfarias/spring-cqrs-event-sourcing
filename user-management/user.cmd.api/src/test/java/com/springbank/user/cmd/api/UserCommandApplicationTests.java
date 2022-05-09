package com.springbank.user.cmd.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Slf4j
@SpringBootTest
class UserCommandApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void test() {
		log.error(new BCryptPasswordEncoder(12).encode("P@ssw0rd3"));
	}

}
