package com.example.eventslistners.resources;

import com.example.eventslistners.model.Author;
import com.example.eventslistners.services.interfaces.AuthorService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RestController
@RequestMapping("author")
public class AuthorResource {

    private final AuthorService authorService;

    public AuthorResource(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/{id}")
    public Author findById(@PathVariable Long id) {
        return authorService.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @PostMapping
    public Author save(@RequestBody @Valid Author author) {
        return authorService.save(author);
    }

    @PutMapping("/{id}")
    public Author update(@PathVariable Long id, @RequestBody @Valid Author author) {
        return authorService.update(id, author);
    }
}
