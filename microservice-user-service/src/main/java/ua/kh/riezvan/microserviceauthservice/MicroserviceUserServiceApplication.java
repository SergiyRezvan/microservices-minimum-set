package ua.kh.riezvan.microserviceauthservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoReactiveAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = MongoReactiveAutoConfiguration.class)
@EnableDiscoveryClient
public class MicroserviceUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceUserServiceApplication.class, args);
    }

}
