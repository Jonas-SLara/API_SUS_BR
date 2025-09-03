package com.csi.sus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@SpringBootApplication
@RestController
public class SusApplication {

	public static void main(String[] args) {
		SpringApplication.run(SusApplication.class, args);
	}

	@GetMapping("/")
	public String getMethodName() {
		return new String("Olá API");
	}
	

}
