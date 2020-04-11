package com.example.eventslistners.services;

import com.example.eventslistners.exceptions.EmailAlreadyExistsException;
import com.example.eventslistners.model.Author;
import com.example.eventslistners.repository.AuthorRepository;
import com.example.eventslistners.services.interfaces.publishers.AuthorPublisherEvent;
import com.example.eventslistners.services.interfaces.AuthorService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;
    private final AuthorPublisherEvent authorPublisherEvent;

    public AuthorServiceImpl(AuthorRepository repository, AuthorPublisherEvent authorPublisherEvent) {
        this.repository = repository;
        this.authorPublisherEvent = authorPublisherEvent;
    }

    @Override
    public Author save(Author author) {
        if (repository.existsByEmail(author.getEmail())){
            throw new EmailAlreadyExistsException(author.getEmail());
        }
        Author authorSaved = repository.save(author);
        authorPublisherEvent.publishCreatedAuthor(authorSaved);
        return author;
    }

    @Override
    public Author update(Long id, Author author) {
        if (!id.equals(author.getId())){
            throw new IllegalArgumentException();
        }
        Author authorSaved = repository.save(author);
        authorPublisherEvent.publishUpdatedAuthor(authorSaved);
        return authorSaved;
    }

    @Override
    public Optional<Author> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Author getById(Long id) {
        return findById(id).orElse(null);
    }
}
