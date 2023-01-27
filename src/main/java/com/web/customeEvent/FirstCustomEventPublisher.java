package com.web.customeEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class FirstCustomEventPublisher {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishCustomEvent(final String message) {
        System.out.println("Publishing custom event. ");
        FirstCustomEvent firstCustomEvent = new FirstCustomEvent(this, message);
        applicationEventPublisher.publishEvent(firstCustomEvent);
    }
}
