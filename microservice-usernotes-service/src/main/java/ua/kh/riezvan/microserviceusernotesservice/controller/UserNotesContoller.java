package ua.kh.riezvan.microserviceusernotesservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.kh.riezvan.microserviceusernotesservice.repository.model.UserNotesModel;
import ua.kh.riezvan.microserviceusernotesservice.service.UserNoteService;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/userNotes")
public class UserNotesContoller {

    @Autowired
    private UserNoteService userNoteService;

    @GetMapping(path = "/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserNotesModel> findByUsername(@PathVariable String username) {
        return userNoteService.getUserNotes(username);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public UserNotesModel storeNote(@RequestParam("note") String note, @RequestHeader("Authorization") String authHeader) {
        return userNoteService.save(note, authHeader);
    }

}
