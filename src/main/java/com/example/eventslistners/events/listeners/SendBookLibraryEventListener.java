package com.example.eventslistners.events.listeners;

import com.example.eventslistners.dto.LibraryBookPublishedInfo;
import com.example.eventslistners.events.creators.PublicationBookEvent;
import com.example.eventslistners.model.Library;
import com.example.eventslistners.model.LibraryBook;
import com.example.eventslistners.model.PublicationBook;
import com.example.eventslistners.services.interfaces.LibraryService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class SendBookLibraryEventListener {

    private final LibraryService libraryService;

    public SendBookLibraryEventListener(LibraryService libraryService) {
        this.libraryService = libraryService;
    }


    @EventListener
    public LibraryBookPublishedInfo publicationBookEventListener(PublicationBookEvent publicationBookEvent) {
        List<Library> libraries = libraryService.findAll();
        if (!CollectionUtils.isEmpty(libraries)) {
            PublicationBook publicationBook = publicationBookEvent.getValue();
            libraries.forEach(data -> {
                libraryService.addBookToCollection(data, publicationBook.getBook());
            });
            return LibraryBookPublishedInfo.of(libraries, publicationBook.getBook(), publicationBook.getPublicationDate());
        }
        return null;
    }

}
