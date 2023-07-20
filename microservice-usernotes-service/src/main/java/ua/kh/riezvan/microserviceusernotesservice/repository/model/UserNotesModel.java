package ua.kh.riezvan.microserviceusernotesservice.repository.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(value = "userNotes")
public class UserNotesModel {

    @Id
    private String id;

    private String username;

    private String note;

    private String userNameDescription;

    public UserNotesModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getUserNameDescription() {
        return userNameDescription;
    }

    public void setUserNameDescription(String userNameDescription) {
        this.userNameDescription = userNameDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserNotesModel that = (UserNotesModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
