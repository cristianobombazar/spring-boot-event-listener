package com.example.eventslistners.events.listeners;

import com.example.eventslistners.dto.LibraryBookPublishedInfo;
import com.example.eventslistners.services.MailService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SendEmailAuthorEventListener {

    private final MailService mailService;

    public SendEmailAuthorEventListener(MailService mailService) {
        this.mailService = mailService;
    }

    @EventListener
    public void sendEmailAuthor(LibraryBookPublishedInfo publicationBookEvent) {
        mailService.sendEmailToAuthor(publicationBookEvent);
    }
}
