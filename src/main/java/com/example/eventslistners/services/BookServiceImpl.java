package com.example.eventslistners.services;

import com.example.eventslistners.exceptions.BookAlreadyExistsException;
import com.example.eventslistners.model.Book;
import com.example.eventslistners.repository.BookRepository;
import com.example.eventslistners.services.interfaces.BookService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book save(Book book) {
        if (repository.existsByTitleAndAuthor(book.getTitle(), book.getAuthor())){
            throw new BookAlreadyExistsException(book);
        }
        repository.save(book);
        return repository.save(book);
    }

    @Override
    public Book findById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
