package com.example.eventslistners.resources;

import com.example.eventslistners.model.Author;
import com.example.eventslistners.services.interfaces.AuthorService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("author")
public class AuthorResources {

    private final AuthorService authorService;

    public AuthorResources(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/{id}")
    public Author findById(@PathVariable Long id) {
        return authorService.findById(id);
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
