package com.example.eventslistners.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Table
@Entity
public class PublicationBook extends EntityId<Long>  {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @JoinColumn(name = "book_id")
    @ManyToOne
    private Book book;

    @Column
    private LocalDate publicationDate;

    @Column
    private LocalDateTime lastUpdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    @Override
    public void preSave() {
        this.lastUpdate = LocalDateTime.now();
    }

    @Override
    public void preUpdate() {
        this.lastUpdate = LocalDateTime.now();
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublicationBook that = (PublicationBook) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
