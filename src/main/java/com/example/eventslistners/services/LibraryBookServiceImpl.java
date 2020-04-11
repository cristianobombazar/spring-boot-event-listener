package com.example.eventslistners.services;

import com.example.eventslistners.model.LibraryBook;
import com.example.eventslistners.repository.LibraryBookRepository;
import com.example.eventslistners.services.interfaces.LibraryBookService;
import org.springframework.stereotype.Service;

@Service
public class LibraryBookServiceImpl implements LibraryBookService {

    private final LibraryBookRepository repository;

    public LibraryBookServiceImpl(LibraryBookRepository repository) {
        this.repository = repository;
    }

    @Override
    public LibraryBook save(LibraryBook libraryBook) {
        return repository.save(libraryBook);
    }
}
