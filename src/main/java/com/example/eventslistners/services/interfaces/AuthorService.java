package com.example.eventslistners.services.interfaces;

import com.example.eventslistners.model.Author;

import java.util.Optional;

public interface AuthorService {
    Author save(Author author);
    Author update(Long id, Author author);
    Optional<Author> findById(Long id);
    Author getById(Long id);
}
