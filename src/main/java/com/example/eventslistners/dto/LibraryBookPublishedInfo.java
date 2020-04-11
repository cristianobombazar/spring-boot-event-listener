package com.example.eventslistners.dto;

import com.example.eventslistners.model.Book;
import com.example.eventslistners.model.Library;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class LibraryBookPublishedInfo {

    private List<Library> libraries;
    private Book book;
    private LocalDate publicationDate;

    private LibraryBookPublishedInfo(List<Library> libraries, Book book, LocalDate publicationDate) {
        this.libraries = Collections.unmodifiableList(libraries);
        this.book = book;
        this.publicationDate = publicationDate;
    }

    public static LibraryBookPublishedInfo of(List<Library> libraries, Book book, LocalDate publicationDate) {
        return new LibraryBookPublishedInfo(libraries, book, publicationDate);
    }

    public List<Library> getLibraries() {
        return libraries;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }
}
