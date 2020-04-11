package com.example.eventslistners.services.interfaces.publishers;

import com.example.eventslistners.model.Library;

public interface LibraryPublisherEvent extends PublishEvent {
    void publishCreatedLibrary(Library library);
}
