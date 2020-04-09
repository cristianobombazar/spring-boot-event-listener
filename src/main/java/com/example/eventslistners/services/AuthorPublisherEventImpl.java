package com.example.eventslistners.services;

import com.example.eventslistners.events.creators.AuthorCreatedEvent;
import com.example.eventslistners.events.creators.AuthorUpdatedEvent;
import com.example.eventslistners.model.Author;
import com.example.eventslistners.publisher.EventPublisher;
import com.example.eventslistners.services.interfaces.AuthorPublisherEvent;
import org.springframework.stereotype.Service;

@Service
public class AuthorPublisherEventImpl implements AuthorPublisherEvent {

    private final EventPublisher eventPublisher;

    public AuthorPublisherEventImpl(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void publishCreatedAuthor(Author author) {
        AuthorCreatedEvent authorCreatedEvent = new AuthorCreatedEvent(author);
        eventPublisher.publish(authorCreatedEvent);
    }

    @Override
    public void publishUpdatedAuthor(Author author) {
        AuthorUpdatedEvent authorUpdatedEvent = new AuthorUpdatedEvent(author);
        eventPublisher.publish(authorUpdatedEvent);
    }
}
