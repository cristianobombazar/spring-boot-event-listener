package com.example.eventslistners.events.creators;

import com.example.eventslistners.enuns.EventType;
import com.example.eventslistners.model.Book;

public class BookUpdatedEvent extends GenericApplicationEvent<Book> {

    public BookUpdatedEvent(Book book) {
        super(EventType.BOOK_UPDATED, book);
    }
}
