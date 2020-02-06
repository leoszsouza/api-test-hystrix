package com.example.leoclienthystrix;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class LeoClientHystrixApplicationTests {

	@Autowired
	HelloService helloService;

	@Test
	void contextLoads() {
	}

	@Test
	public void testApiHystrix() throws InterruptedException {
		for (int i=0; i<60; i++){
			Thread.sleep(1000);
			System.out.println(helloService.getHello());
		}
	}

}
