package com.example.eventslistners.events.creators;

import com.example.eventslistners.enuns.EventType;
import com.example.eventslistners.model.PublicationBook;

public class PublicationBookEvent extends GenericApplicationEvent<PublicationBook> {

    public PublicationBookEvent(PublicationBook value) {
        super(EventType.PUBLICATION_BOOK, value);
    }
}
