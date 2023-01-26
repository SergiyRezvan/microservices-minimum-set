package ua.kh.riezvan.microserviceusernotesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoReactiveAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import ua.kh.riezvan.microserviceusernotesservice.client.UserDetailsFeignClient;

@SpringBootApplication(exclude = MongoReactiveAutoConfiguration.class)
@EnableDiscoveryClient
@EnableFeignClients(clients = UserDetailsFeignClient.class)
public class MicroserviceUsernotesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceUsernotesServiceApplication.class, args);
	}

}
