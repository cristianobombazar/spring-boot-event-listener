package com.example.eventslistners.events.creators;

import com.example.eventslistners.enuns.EventType;
import com.example.eventslistners.model.Author;

public class AuthorUpdatedEvent extends GenericApplicationEvent<Author> {

    public AuthorUpdatedEvent(Author author) {
        super(EventType.AUTHOR_UPDATED, author);
    }
}
