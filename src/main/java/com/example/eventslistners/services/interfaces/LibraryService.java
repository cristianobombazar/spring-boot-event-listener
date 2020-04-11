package com.example.eventslistners.services.interfaces;

import com.example.eventslistners.model.Book;
import com.example.eventslistners.model.Library;

import java.util.List;
import java.util.Optional;

public interface LibraryService {
    Library save(Library library);
    Optional<Library> findById(Long id);
    Library getById(Long id);
    List<Library> findAll();
    void addBookToCollection(Library library, Book book);
}
