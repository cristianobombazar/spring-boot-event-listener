package com.example.eventslistners.model;

import com.example.eventslistners.enuns.Category;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Table
@Entity
public class Book extends EntityId<Long> {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    @NotNull
    private String title;

    @Column
    @NotNull
    private String description;

    @Column
    @Enumerated(EnumType.STRING)
    @NotNull
    private Category category;

    @JoinColumn(name = "author_id")
    @ManyToOne
    @NotNull
    private Author author;

    @Column
    private LocalDateTime lastUpdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    @Override
    @PrePersist
    public void preSave() {
        this.lastUpdate = LocalDateTime.now();
    }

    @Override
    @PreUpdate
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
        Book book = (Book) o;
        return id.equals(book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
