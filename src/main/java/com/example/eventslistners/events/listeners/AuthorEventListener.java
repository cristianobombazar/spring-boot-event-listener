package com.example.eventslistners.events.listeners;

import com.example.eventslistners.enuns.EventType;
import com.example.eventslistners.events.creators.AuthorCreatedEvent;
import com.example.eventslistners.events.creators.AuthorUpdatedEvent;
import com.example.eventslistners.model.EventHistory;
import com.example.eventslistners.services.interfaces.EventHistoryService;
import com.example.eventslistners.util.ObjectMapperUtil;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AuthorEventListener implements CustomEventListener {

    private final EventHistoryService eventHistoryService;

    public AuthorEventListener(EventHistoryService eventHistoryService) {
        this.eventHistoryService = eventHistoryService;
    }

    @EventListener
    public void authorCreatedListener(AuthorCreatedEvent authorCreatedEvent) {
        this.save(authorCreatedEvent.getEventType(), ObjectMapperUtil.toString(authorCreatedEvent.getAuthor()));
    }

    @EventListener
    public void authorCreatedListener(AuthorUpdatedEvent authorUpdatedEvent) {
        this.save(authorUpdatedEvent.getEventType(), ObjectMapperUtil.toString(authorUpdatedEvent.getAuthor()));
    }

    @Override
    public EventHistory save(EventType eventType, String value) {
        EventHistory eventHistory = new EventHistory();
        eventHistory.setEventType(eventType);
        eventHistory.setValue(value);
        return eventHistoryService.save(eventHistory);
    }
}
