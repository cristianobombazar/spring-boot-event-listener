package com.example.eventslistners.dto.resources.author;

import com.example.eventslistners.model.Author;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AuthorDTO {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;
    private LocalDateTime lastUpdate;
    @JsonProperty("_histories")
    private String histories;

    public AuthorDTO(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.lastName = author.getLastName();
        this.email = author.getEmail();
        this.dateOfBirth = author.getDateOfBirth();
        this.lastUpdate = author.getLastUpdate();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setHistories(String histories) {
        this.histories = histories;
    }

    public String getHistories() {
        return histories;
    }
}
