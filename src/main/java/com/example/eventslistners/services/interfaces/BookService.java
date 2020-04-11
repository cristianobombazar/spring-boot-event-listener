package com.example.eventslistners.services.interfaces;

import com.example.eventslistners.model.Book;

import java.util.Optional;

public interface BookService {
    Book save(Book book);
    Optional<Book> findById(Long id);
    Book getById(Long id);
}
