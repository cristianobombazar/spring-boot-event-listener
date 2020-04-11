package com.example.eventslistners.events.creators;

import com.example.eventslistners.enuns.EventType;
import com.example.eventslistners.model.Library;

public class LibraryCreatedEvent extends GenericApplicationEvent<Library> {

    public LibraryCreatedEvent(Library value) {
        super(EventType.LIBRARY_CREATED, value);
    }
}
