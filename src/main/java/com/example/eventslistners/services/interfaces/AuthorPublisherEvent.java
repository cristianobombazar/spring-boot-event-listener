package com.example.eventslistners.services.interfaces;

import com.example.eventslistners.model.Author;

public interface AuthorPublisherEvent extends PublishEvent {
    void publishCreatedAuthor(Author author);
    void publishUpdatedAuthor(Author author);
}
