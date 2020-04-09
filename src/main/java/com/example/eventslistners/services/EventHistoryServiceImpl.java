package com.example.eventslistners.services;

import com.example.eventslistners.model.EventHistory;
import com.example.eventslistners.repository.EventHistoryRepository;
import com.example.eventslistners.services.interfaces.EventHistoryService;
import org.springframework.stereotype.Service;

@Service
public class EventHistoryServiceImpl implements EventHistoryService {

    private final EventHistoryRepository eventHistoryRepository;

    public EventHistoryServiceImpl(EventHistoryRepository eventHistory) {
        this.eventHistoryRepository = eventHistory;
    }

    @Override
    public EventHistory save(EventHistory eventHistory) {
        return eventHistoryRepository.save(eventHistory);
    }
}
