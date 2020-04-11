package com.example.eventslistners.services.publishers;

import com.example.eventslistners.events.creators.LibraryCreatedEvent;
import com.example.eventslistners.model.Library;
import com.example.eventslistners.publisher.EventPublisher;
import com.example.eventslistners.services.interfaces.publishers.LibraryPublisherEvent;
import org.springframework.stereotype.Service;

@Service
public class LibraryPublisherEventImpl implements LibraryPublisherEvent {

    private final EventPublisher eventPublisher;

    public LibraryPublisherEventImpl(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void publishCreatedLibrary(Library library) {
        eventPublisher.publish(new LibraryCreatedEvent(library));
    }
}
