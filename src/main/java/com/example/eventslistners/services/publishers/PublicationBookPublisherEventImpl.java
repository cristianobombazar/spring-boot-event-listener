package com.example.eventslistners.services.publishers;

import com.example.eventslistners.events.creators.PublicationBookEvent;
import com.example.eventslistners.model.PublicationBook;
import com.example.eventslistners.publisher.EventPublisher;
import com.example.eventslistners.services.interfaces.publishers.PublicationBookPublisherEvent;
import org.springframework.stereotype.Service;

@Service
public class PublicationBookPublisherEventImpl implements PublicationBookPublisherEvent {

    private final EventPublisher eventPublisher;

    public PublicationBookPublisherEventImpl(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void publishPublicationBook(PublicationBook publicationBook) {
        eventPublisher.publish(new PublicationBookEvent(publicationBook));
    }
}
