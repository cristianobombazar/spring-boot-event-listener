package com.example.eventslistners.services.interfaces.publishers;

import com.example.eventslistners.model.Book;

public interface BookPublisherEvent extends PublishEvent {
    void publishCreatedBook(Book book);
}
