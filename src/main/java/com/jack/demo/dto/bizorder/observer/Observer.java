package com.jack.demo.dto.bizorder.observer;

import org.springframework.stereotype.Component;

@Component
public abstract class Observer {

    protected Subject subject;

    public abstract void update();
}
