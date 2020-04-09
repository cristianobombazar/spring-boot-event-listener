package com.example.eventslistners.publisher;

import com.example.eventslistners.events.creators.GenericEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;
    private final ThreadPoolTaskExecutor threadPoolTaskExecutor;

    public EventPublisher(ApplicationEventPublisher applicationEventPublisher, ThreadPoolTaskExecutor threadPoolTaskExecutor) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.threadPoolTaskExecutor = threadPoolTaskExecutor;
    }

    public void publish(GenericEvent genericApplicationEvent){
        threadPoolTaskExecutor.execute(() -> applicationEventPublisher.publishEvent(genericApplicationEvent));
    }
}
