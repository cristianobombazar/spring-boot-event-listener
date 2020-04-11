package com.example.eventslistners.services.interfaces.publishers;

import com.example.eventslistners.model.Author;

public interface AuthorPublisherEvent extends PublishEvent {
    void publishCreatedAuthor(Author author);
    void publishUpdatedAuthor(Author author);
}
