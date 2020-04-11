package com.example.eventslistners.events.creators;

import com.example.eventslistners.enuns.EventType;
import com.example.eventslistners.model.Author;

public class AuthorCreatedEvent extends GenericApplicationEvent<Author> {

    public AuthorCreatedEvent(Author author) {
        super(EventType.AUTHOR_CREATED, author);
    }
}
