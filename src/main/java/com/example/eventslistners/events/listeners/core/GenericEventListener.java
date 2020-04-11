package com.example.eventslistners.events.listeners.core;

import com.example.eventslistners.enuns.EventType;
import com.example.eventslistners.model.EventHistory;
import com.example.eventslistners.services.interfaces.EventHistoryService;

public class GenericEventListener implements CustomEventListener {

    private final EventHistoryService eventHistoryService;

    public GenericEventListener(EventHistoryService eventHistoryService) {
        this.eventHistoryService = eventHistoryService;
    }

    @Override
    public EventHistory save(EventType eventType, String value) {
        EventHistory eventHistory = new EventHistory();
        eventHistory.setEventType(eventType);
        eventHistory.setValue(value);
        return eventHistoryService.save(eventHistory);
    }
}
