package com.example.leoclienthystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class HelloService {


    private final RestTemplate restTemplate;

    public HelloService(RestTemplate rest) {
        this.restTemplate = rest;
    }

    @HystrixCommand(fallbackMethod = "openCircuitFallback")
    public String getHello() {
        URI uri = URI.create("http://localhost:8085/v1/test/hello");

        return this.restTemplate.getForObject(uri, String.class);
    }

    public String openCircuitFallback() {
        return "Hello from Hystrix";
    }
}
