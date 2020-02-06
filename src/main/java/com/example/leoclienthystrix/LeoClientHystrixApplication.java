package com.example.leoclienthystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableCircuitBreaker
@EnableHystrixDashboard
@SpringBootApplication
public class LeoClientHystrixApplication {

	@Autowired
	private HelloService helloService;

	@Bean
	public RestTemplate rest(RestTemplateBuilder builder) {
		return builder.build();
	}

	@RequestMapping("/test-hello-api")
	public String toRead() {
		return helloService.getHello();
	}

	public static void main(String[] args) {
		SpringApplication.run(LeoClientHystrixApplication.class, args);
	}

}
