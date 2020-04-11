package com.example.eventslistners.services;

import com.example.eventslistners.exceptions.BookAlreadyExistsException;
import com.example.eventslistners.model.Book;
import com.example.eventslistners.repository.BookRepository;
import com.example.eventslistners.services.interfaces.BookService;
import com.example.eventslistners.services.interfaces.publishers.BookPublisherEvent;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;
    private final BookPublisherEvent bookPublisherEvent;

    public BookServiceImpl(BookRepository repository, BookPublisherEvent bookPublisherEvent) {
        this.repository = repository;
        this.bookPublisherEvent = bookPublisherEvent;
    }

    @Override
    public Book save(Book book) {
        if (repository.existsByTitleAndAuthor(book.getTitle(), book.getAuthor())){
            throw new BookAlreadyExistsException(book);
        }
        Book bookSaved = repository.save(book);
        bookPublisherEvent.publishCreatedBook(bookSaved);
        return bookSaved;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Book getById(Long id) {
        return findById(id).orElse(null);
    }
}
