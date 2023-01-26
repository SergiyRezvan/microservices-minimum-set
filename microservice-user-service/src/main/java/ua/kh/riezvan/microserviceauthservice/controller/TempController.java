package ua.kh.riezvan.microserviceauthservice.controller;

import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TempController {

    @GetMapping(value = "checkToken", produces = MediaType.APPLICATION_JSON_VALUE)
    public String checkToken() {
        return """
               {
                 "result": "endpoint with authentication"
               }
                """;
    }

    @GetMapping(value = "openEndpoint", produces = MediaType.APPLICATION_JSON_VALUE)
    public String openEndpoint() {
        return """
               {
                 "result": "endpoint without authentication"
               }
                """;
    }

}
