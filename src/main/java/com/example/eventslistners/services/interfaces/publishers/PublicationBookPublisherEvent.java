package com.example.eventslistners.services.interfaces.publishers;

import com.example.eventslistners.model.PublicationBook;

public interface PublicationBookPublisherEvent extends PublishEvent {
    void publishPublicationBook(PublicationBook publicationBook);
}
