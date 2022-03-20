package com.seunghwan.kafkastudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkastudyApplication {


	public static void main(String[] args) {
		SpringApplication.run(KafkastudyApplication.class, args);

		Consumer consumer = new Consumer();
		consumer.listen();
	}

}
