package com.example.eventslistners.events.listeners;

import com.example.eventslistners.events.creators.BookCreatedEvent;
import com.example.eventslistners.events.listeners.core.GenericEventListener;
import com.example.eventslistners.services.interfaces.EventHistoryService;
import com.example.eventslistners.util.ObjectMapperUtil;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BookEventListener extends GenericEventListener {

    public BookEventListener(EventHistoryService eventHistoryService) {
        super(eventHistoryService);
    }

    @EventListener
    public void bookCreatedListener(BookCreatedEvent bookCreatedEvent) {
        super.save(bookCreatedEvent.getEventType(), ObjectMapperUtil.toString(bookCreatedEvent.getValue()));
    }
}
