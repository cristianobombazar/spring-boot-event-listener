package com.example.eventslistners.events.listeners.core;

import com.example.eventslistners.enuns.EventType;
import com.example.eventslistners.model.EventHistory;

public interface CustomEventListener {
    EventHistory save(EventType eventType, String value);
}
