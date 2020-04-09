package com.example.eventslistners.services.interfaces;

import com.example.eventslistners.model.Book;

public interface BookService {
    Book save(Book book);
    Book findById(Long id);
}
