package com.simplenewsaggregator.simplenewsaggregator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.simplenewsaggregator.simplenewsaggregator.services.XMLUnmarshalService;

@SpringBootApplication
public class SimplenewsaggregatorApplication {

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(SimplenewsaggregatorApplication.class, args);
	}

}
