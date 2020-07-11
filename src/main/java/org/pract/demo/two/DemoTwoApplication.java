package org.pract.demo.two;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoTwoApplication.class, args);
	}

}
