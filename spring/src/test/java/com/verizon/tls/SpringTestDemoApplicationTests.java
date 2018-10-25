package com.verizon.tls;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.verizon.tls.controller.WelcomeController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTestDemoApplicationTests {

	@Test
	public void contextLoads() {
		assertThat(WelcomeController.class)
		.isNotNull()
		.hasMethods("showHome"); 
	}

}
