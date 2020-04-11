package com.example.eventslistners.services.publishers;

import com.example.eventslistners.events.creators.AuthorCreatedEvent;
import com.example.eventslistners.events.creators.AuthorUpdatedEvent;
import com.example.eventslistners.model.Author;
import com.example.eventslistners.publisher.EventPublisher;
import com.example.eventslistners.services.interfaces.publishers.AuthorPublisherEvent;
import org.springframework.stereotype.Service;

@Service
public class AuthorPublisherEventImpl implements AuthorPublisherEvent {

    private final EventPublisher eventPublisher;

    public AuthorPublisherEventImpl(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void publishCreatedAuthor(Author author) {
        eventPublisher.publish(new AuthorCreatedEvent(author));
    }

    @Override
    public void publishUpdatedAuthor(Author author) {
        eventPublisher.publish(new AuthorUpdatedEvent(author));
    }
}
