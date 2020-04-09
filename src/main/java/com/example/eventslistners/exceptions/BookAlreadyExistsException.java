package com.example.eventslistners.exceptions;

import com.example.eventslistners.model.Book;

public class BookAlreadyExistsException extends RuntimeException {
    public BookAlreadyExistsException(Book book){
        super("The book '"+book.getTitle()+" of the author "+book.getAuthor().getName()+" already exists.");
    }
}
