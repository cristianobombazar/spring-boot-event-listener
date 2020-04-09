package com.example.eventslistners.services.interfaces;

import com.example.eventslistners.model.Author;

public interface AuthorService {
    Author save(Author author);
    Author update(Long id, Author author);
    Author findById(Long id);
}
