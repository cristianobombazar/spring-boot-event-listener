package com.example.eventslistners.resources;

import com.example.eventslistners.model.Library;
import com.example.eventslistners.services.interfaces.LibraryService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RestController
@RequestMapping("library")
public class LibraryResource {

    private final LibraryService libraryService;

    public LibraryResource(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping
    public Library save(@RequestBody @Valid Library library) {
        return libraryService.save(library);
    }

    @GetMapping("/{id}")
    public Library findById(@PathVariable Long id) {
        return libraryService.findById(id).orElseThrow(EntityNotFoundException::new);
    }

}
