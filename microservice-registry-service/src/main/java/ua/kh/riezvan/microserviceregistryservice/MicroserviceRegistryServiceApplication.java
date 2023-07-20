package ua.kh.riezvan.microserviceregistryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.tracing.ConditionalOnEnabledTracing;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroserviceRegistryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceRegistryServiceApplication.class, args);
	}

}
