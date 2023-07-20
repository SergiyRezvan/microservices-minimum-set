package ua.kh.riezvan.microserviceapigateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.csrf.CookieServerCsrfTokenRepository;
import org.springframework.security.web.server.csrf.WebSessionServerCsrfTokenRepository;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityWebFilterChain filterChain(ServerHttpSecurity security) throws Exception {
        security.cors().and()
                .authorizeExchange().pathMatchers("/users/checkToken")
                .authenticated()
                .and()
                .authorizeExchange().pathMatchers("/users/openEndpoint").permitAll()
                .and()
                .authorizeExchange().pathMatchers("/uaa/token").permitAll()
                .and()
                .authorizeExchange().pathMatchers("/users/userDetails/**").authenticated()
                .and()
                .authorizeExchange().pathMatchers("/notes/**").authenticated()
                .and()
                .authorizeExchange().pathMatchers("/actuator/**").permitAll()
                .and()
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .oauth2ResourceServer()
                .jwt();
        return security.build();
    }

}
