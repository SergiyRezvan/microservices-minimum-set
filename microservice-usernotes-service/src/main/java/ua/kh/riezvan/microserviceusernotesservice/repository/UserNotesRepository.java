package ua.kh.riezvan.microserviceusernotesservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import ua.kh.riezvan.microserviceusernotesservice.repository.model.UserNotesModel;

@Repository
public interface UserNotesRepository extends ReactiveMongoRepository<UserNotesModel, String> {

    Flux<UserNotesModel> findByUsername(String username);

}
