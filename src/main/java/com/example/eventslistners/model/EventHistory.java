package com.example.eventslistners.model;

import com.example.eventslistners.enuns.EventType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Table
@Entity
public class EventHistory extends EntityId<Long> {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column@Enumerated(EnumType.STRING)
    @NotNull
    private EventType eventType;

    @Column
    @NotNull
    @Lob
    private String value;

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

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    @Override
    @PrePersist
    public void preSave() {
        this.lastUpdate = LocalDateTime.now();
    }

    @Override
    public void preUpdate() {
        this.lastUpdate = LocalDateTime.now();
    }

    @Override
    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventHistory that = (EventHistory) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
