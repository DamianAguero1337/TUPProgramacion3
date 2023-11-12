package com.bmollaret.security_gradle_jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityGradleJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityGradleJwtApplication.class, args);
		System.out.println("----¡funciona!----");
	}

}
