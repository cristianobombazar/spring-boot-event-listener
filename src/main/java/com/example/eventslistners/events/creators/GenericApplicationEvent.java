package com.example.eventslistners.events.creators;

import com.example.eventslistners.enuns.EventType;

public class GenericApplicationEvent<E> implements GenericEvent  {

    private final EventType eventType;
    private final E object;

    public GenericApplicationEvent(EventType eventType, E object) {
        this.eventType = eventType;
        this.object = object;
    }

    public EventType getEventType() {
        return eventType;
    }

    E getObject() {
        return object;
    }
}
