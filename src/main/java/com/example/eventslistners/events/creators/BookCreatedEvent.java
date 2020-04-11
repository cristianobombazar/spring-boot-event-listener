package com.example.eventslistners.events.creators;

import com.example.eventslistners.enuns.EventType;
import com.example.eventslistners.model.Book;

public class BookCreatedEvent extends GenericApplicationEvent<Book> {

    public BookCreatedEvent(Book book) {
        super(EventType.BOOK_CREATED, book);
    }
}
