package com.example.eventslistners.events.listeners;

import com.example.eventslistners.events.creators.AuthorCreatedEvent;
import com.example.eventslistners.events.creators.AuthorUpdatedEvent;
import com.example.eventslistners.events.listeners.core.GenericEventListener;
import com.example.eventslistners.services.interfaces.EventHistoryService;
import com.example.eventslistners.util.ObjectMapperUtil;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AuthorEventListener extends GenericEventListener {

    public AuthorEventListener(EventHistoryService eventHistoryService) {
        super(eventHistoryService);
    }

    @EventListener
    public void authorCreatedListener(AuthorCreatedEvent authorCreatedEvent) {
        this.save(authorCreatedEvent.getEventType(), ObjectMapperUtil.toString(authorCreatedEvent.getValue()));
    }

    @EventListener
    public void authorCreatedListener(AuthorUpdatedEvent authorUpdatedEvent) {
        this.save(authorUpdatedEvent.getEventType(), ObjectMapperUtil.toString(authorUpdatedEvent.getValue()));
    }

}
