package com.example.eventslistners.events.listeners;

import com.example.eventslistners.events.creators.LibraryCreatedEvent;
import com.example.eventslistners.events.listeners.core.GenericEventListener;
import com.example.eventslistners.services.interfaces.EventHistoryService;
import com.example.eventslistners.util.ObjectMapperUtil;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class LibraryEventListener extends GenericEventListener{

    public LibraryEventListener(EventHistoryService eventHistoryService) {
        super(eventHistoryService);
    }

    @EventListener
    public void libraryCreatedListener(LibraryCreatedEvent libraryCreatedEvent) {
        super.save(libraryCreatedEvent.getEventType(), ObjectMapperUtil.toString(libraryCreatedEvent.getValue()));
    }
}
