package ua.kh.riezvan.microserviceauthservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import ua.kh.riezvan.microserviceauthservice.repository.model.UserDetails;

@Repository
public interface UserDetailsRepository extends ReactiveMongoRepository<UserDetails, String> {

    Mono<UserDetails> findByUsername(String userName);

}
