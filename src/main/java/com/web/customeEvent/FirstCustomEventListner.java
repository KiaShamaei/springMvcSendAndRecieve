package com.web.customeEvent;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class FirstCustomEventListner {
    @EventListener
    public void getEvent(FirstCustomEvent event){
        System.out.println(event.getMsg());
    }
}
