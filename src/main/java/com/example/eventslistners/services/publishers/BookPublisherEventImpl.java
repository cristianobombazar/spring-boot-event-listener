package com.example.eventslistners.services.publishers;

import com.example.eventslistners.events.creators.BookCreatedEvent;
import com.example.eventslistners.model.Book;
import com.example.eventslistners.publisher.EventPublisher;
import com.example.eventslistners.services.interfaces.publishers.BookPublisherEvent;
import org.springframework.stereotype.Service;

@Service
public class BookPublisherEventImpl implements BookPublisherEvent {

    private final EventPublisher eventPublisher;

    public BookPublisherEventImpl(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void publishCreatedBook(Book book) {
        eventPublisher.publish(new BookCreatedEvent(book));
    }
}
