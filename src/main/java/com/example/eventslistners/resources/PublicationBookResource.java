package com.example.eventslistners.resources;

import com.example.eventslistners.model.PublicationBook;
import com.example.eventslistners.services.interfaces.BookService;
import com.example.eventslistners.services.interfaces.PublicationBookService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/book/{bookId}/publish")
public class PublicationBookResource {

    private final BookService bookService;
    private final PublicationBookService publicationBookService;

    public PublicationBookResource(BookService bookService, PublicationBookService publicationBookService) {
        this.bookService = bookService;
        this.publicationBookService = publicationBookService;
    }

    @PostMapping
    public PublicationBook publishBook(@PathVariable Long bookId){
        return bookService.findById(bookId).map(publicationBookService::publishBook).orElseThrow(EntityNotFoundException::new);
    }

}
