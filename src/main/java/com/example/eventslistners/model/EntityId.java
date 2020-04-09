package com.example.eventslistners.model;

import java.time.LocalDateTime;

public abstract class EntityId<ID> {
    abstract void setId(ID id);
    abstract ID getId();
    abstract void setLastUpdate(LocalDateTime lastUpdate);
    abstract LocalDateTime getLastUpdate();
    abstract public void preSave();
    abstract public void preUpdate();
}
