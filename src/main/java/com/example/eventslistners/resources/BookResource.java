package com.example.eventslistners.resources;

import com.example.eventslistners.model.Book;
import com.example.eventslistners.services.interfaces.BookService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RestController
@RequestMapping("book")
public class BookResource {

    private final BookService bookService;

    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id) {
        return bookService.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @PostMapping
    public Book save(@RequestBody @Valid Book book) {
        return bookService.save(book);
    }
}
