package com.example.eventslistners.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table
public class LibraryBook extends EntityId<Long> {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime lastUpdate;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    @Override
    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    @PrePersist
    public void preSave() {
        this.lastUpdate = LocalDateTime.now();
        this.createdAt = LocalDateTime.now();
    }

    @Override
    @PreUpdate
    public void preUpdate() {
        this.lastUpdate = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryBook that = (LibraryBook) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
