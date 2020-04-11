package com.example.eventslistners.events.creators;

import com.example.eventslistners.enuns.EventType;

public class GenericApplicationEvent<E> implements GenericEvent  {

    private final EventType eventType;
    private final E value;

    public GenericApplicationEvent(EventType eventType, E value) {
        this.eventType = eventType;
        this.value = value;
    }

    public EventType getEventType() {
        return eventType;
    }

    public E getValue() {
        return value;
    }
}
