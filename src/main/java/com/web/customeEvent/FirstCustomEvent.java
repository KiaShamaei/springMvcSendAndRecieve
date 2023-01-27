package com.web.customeEvent;


import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;


@Getter
@Setter
public class FirstCustomEvent extends ApplicationEvent {
    private String msg;

    public FirstCustomEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }
}
