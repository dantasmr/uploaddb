package com.upload.db.uploaddb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UploaddbApplication {

	public static void main(String[] args) {
		SpringApplication.run(UploaddbApplication.class, args);
	}
}
