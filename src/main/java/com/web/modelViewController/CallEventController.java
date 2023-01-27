package com.web.modelViewController;

import com.web.customeEvent.FirstCustomEvent;
import com.web.customeEvent.FirstCustomEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CallEventController {
    final FirstCustomEventPublisher firstCustomEventPublisher;

    public CallEventController(FirstCustomEventPublisher firstCustomEventPublisher) {
        this.firstCustomEventPublisher = firstCustomEventPublisher;
    }

    @GetMapping("/call/event/{name}")
    public String callEvent(@PathVariable String name){
        firstCustomEventPublisher.publishCustomEvent("event call in controller");
        firstCustomEventPublisher.publishCustomEvent(name);
        return "home";
    }
}
