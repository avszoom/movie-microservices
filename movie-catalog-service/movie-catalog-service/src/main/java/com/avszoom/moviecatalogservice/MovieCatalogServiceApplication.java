package com.avszoom.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

/*
* This tells application is spring boot and start scanning and launch server
* */
@SpringBootApplication
public class MovieCatalogServiceApplication {

	/*
	* bean creates a resource, usually we put it over a method like below. When spring starts it collects all such
	* beans store it in application context and during component scan anyone needs it , it passes same instance. Hence
	* beans are by default singleton.
	* */
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public WebClient.Builder getWebClientBuilder() {
		return  WebClient.builder();
	}

	public static void main(String[] args) {
		/*
		*  this tells that this is starting class for spring boot.
		* it start component scans
		* creation of application context
		* start tomcat server
		* */
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

}
