package ua.kh.riezvan.microserviceauthservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kh.riezvan.microserviceauthservice.repository.model.UserDetails;
import ua.kh.riezvan.microserviceauthservice.service.UserDetailsService;

import java.util.List;

@RestController
@RequestMapping("/userDetails")
public class UserDetailsController {

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDetails> getAllUsers() {
        return userDetailsService.getAllUserDetails();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDetails> createUserDetails(@RequestBody UserDetails userDetails) {
        return ResponseEntity.ok(userDetailsService.createUserDetails(userDetails));
    }

    @GetMapping(path = "/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDetails getUserDetails(@PathVariable("userName") String username) {
        return userDetailsService.getUserDetails(username);
    }

}
