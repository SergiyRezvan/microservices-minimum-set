package ua.kh.riezvan.microserviceusernotesservice.service;

import com.nimbusds.jwt.JWTParser;
import io.micrometer.observation.annotation.Observed;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import ua.kh.riezvan.microserviceusernotesservice.client.UserDetailsFeignClient;
import ua.kh.riezvan.microserviceusernotesservice.client.model.UserDetailsDTO;
import ua.kh.riezvan.microserviceusernotesservice.repository.UserNotesRepository;
import ua.kh.riezvan.microserviceusernotesservice.repository.model.UserNotesModel;

import java.util.List;

@Service
public class UserNoteService {

    private final UserNotesRepository userNotesRepository;

    private final UserDetailsFeignClient userDetailsClient;

    public UserNoteService(UserNotesRepository userNotesRepository, UserDetailsFeignClient userDetailsClient) {
        this.userNotesRepository = userNotesRepository;
        this.userDetailsClient = userDetailsClient;
    }

    @Observed(name = "all.user.notes",
            contextualName = "getting-all-user-notes")
    public List<UserNotesModel> getUserNotes(String username) {
        return userNotesRepository.findByUsername(username).toStream().toList();
    }

    @Observed(name = "save.user.note",
            contextualName = "save-new-user-note")
    public UserNotesModel save(String userNote, String authToken) {
        if (StringUtils.isBlank(authToken) || !authToken.startsWith("Bearer ")) {
            throw new IllegalArgumentException("Auth token has to be provided!");
        }
        try {
            String userName = (String) JWTParser.parse(authToken.split("Bearer ")[1]).getJWTClaimsSet().getClaims().get("preferred_username");
            UserDetailsDTO userDetails = userDetailsClient.getUserDetails(userName);
            var userNoteModel = new UserNotesModel();
            userNoteModel.setNote(userNote);
            userNoteModel.setUsername(userDetails.getUsername());
            userNoteModel.setUserNameDescription(userDetails.getDescription());
            return userNotesRepository.save(userNoteModel).block();
        } catch (Exception ex) {
            throw new RuntimeException("Unable to get User notes, due to " + ex);
        }
    }

}
