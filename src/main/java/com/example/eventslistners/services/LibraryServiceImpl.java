package com.example.eventslistners.services;

import com.example.eventslistners.model.Book;
import com.example.eventslistners.model.Library;
import com.example.eventslistners.model.LibraryBook;
import com.example.eventslistners.repository.LibraryRepository;
import com.example.eventslistners.services.interfaces.LibraryBookService;
import com.example.eventslistners.services.interfaces.LibraryService;
import com.example.eventslistners.services.interfaces.publishers.LibraryPublisherEvent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService {

    private final LibraryRepository repository;
    private final LibraryPublisherEvent libraryPublisherEvent;
    private final LibraryBookService libraryBookService;

    public LibraryServiceImpl(LibraryRepository repository, LibraryPublisherEvent libraryPublisherEvent, LibraryBookService libraryBookService) {
        this.repository = repository;
        this.libraryPublisherEvent = libraryPublisherEvent;
        this.libraryBookService = libraryBookService;
    }

    @Override
    public Library save(Library library) {
        Library librarySaved = repository.save(library);
        libraryPublisherEvent.publishCreatedLibrary(librarySaved);
        return librarySaved;
    }

    @Override
    public Optional<Library> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Library getById(Long id) {
        return findById(id).orElse(null);
    }

    @Override
    public List<Library> findAll() {
        return repository.findAll();
    }

    @Override
    public void addBookToCollection(Library library, Book book) {
        LibraryBook libraryBook = new LibraryBook();
        libraryBook.setLibrary(library);
        libraryBook.setBook(book);
        libraryBookService.save(libraryBook);
    }
}
