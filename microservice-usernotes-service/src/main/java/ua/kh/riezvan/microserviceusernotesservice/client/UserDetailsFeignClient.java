package ua.kh.riezvan.microserviceusernotesservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.kh.riezvan.microserviceusernotesservice.client.model.UserDetailsDTO;

@FeignClient(name = "USER-SERVICE", path = "/userService")
public interface UserDetailsFeignClient {

    @GetMapping(path = "/userDetails/{username}")
    UserDetailsDTO getUserDetails(@PathVariable("username") String username);

}
