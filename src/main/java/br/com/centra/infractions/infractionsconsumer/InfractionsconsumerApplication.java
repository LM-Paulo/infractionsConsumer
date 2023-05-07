package br.com.centra.infractions.infractionsconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class InfractionsconsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfractionsconsumerApplication.class, args);
	}

}
