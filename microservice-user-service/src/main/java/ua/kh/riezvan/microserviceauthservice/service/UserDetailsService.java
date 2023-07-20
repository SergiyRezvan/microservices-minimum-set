package ua.kh.riezvan.microserviceauthservice.service;

import io.micrometer.observation.annotation.Observed;
import org.springframework.stereotype.Service;
import ua.kh.riezvan.microserviceauthservice.repository.UserDetailsRepository;
import ua.kh.riezvan.microserviceauthservice.repository.model.UserDetails;

import java.util.List;

@Service
public class UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;

    public UserDetailsService(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @Observed(name = "all.users",
            contextualName = "getting-all-users")
    public List<UserDetails> getAllUserDetails() {
        return userDetailsRepository.findAll().toStream().toList();
    }

    @Observed(name = "create.user",
            contextualName = "create-user")
    public UserDetails createUserDetails(UserDetails newUser) {
        return userDetailsRepository.save(newUser).block();
    }

    @Observed(name = "get.user.details",
            contextualName = "get-user-detail")
    public UserDetails getUserDetails(String username) {
        return userDetailsRepository.findByUsername(username).block();
    }
}
