package com.example.eventslistners.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table
public class Library extends EntityId<Long> {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    @NotNull
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdated) {
        this.lastUpdate = lastUpdated;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return id.equals(library.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
