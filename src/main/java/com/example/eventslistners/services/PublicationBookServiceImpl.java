package com.example.eventslistners.services;

import com.example.eventslistners.model.Book;
import com.example.eventslistners.model.PublicationBook;
import com.example.eventslistners.repository.PublicationBookRepository;
import com.example.eventslistners.services.interfaces.PublicationBookService;
import com.example.eventslistners.services.interfaces.publishers.PublicationBookPublisherEvent;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PublicationBookServiceImpl implements PublicationBookService {

    private final PublicationBookRepository repository;
    private final PublicationBookPublisherEvent publicationBookPublisherEvent;

    public PublicationBookServiceImpl(PublicationBookRepository repository, PublicationBookPublisherEvent publicationBookPublisherEvent) {
        this.repository = repository;
        this.publicationBookPublisherEvent = publicationBookPublisherEvent;
    }

    @Override
    public PublicationBook publishBook(Book book) {
        PublicationBook publicationBook = new PublicationBook();
        publicationBook.setPublicationDate(LocalDate.now());
        publicationBook.setBook(book);
        PublicationBook publicationBookSaved = repository.save(publicationBook);
        publicationBookPublisherEvent.publishPublicationBook(publicationBook);
        return publicationBookSaved;
    }
}
