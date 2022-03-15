package com.jack.demo.dto.bizorder.observer;

import com.jack.demo.dto.bizorder.req.BizOrderCreateReq;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Subject {

    private BizOrderCreateReq bizOrderCreateReq;
    private final List<Observer> observes = new ArrayList<>();

    public BizOrderCreateReq getBizOrderCreateReq() {
        return bizOrderCreateReq;
    }

    // 数据已变更，通知观察者们
    public void setBizOrderCreateReq(BizOrderCreateReq bizOrderCreateReq) {
        this.bizOrderCreateReq = bizOrderCreateReq;
        notifyAll(observes);
    }

    // 注册观察者
    public void attach(Observer observer) {
        observes.add(observer);
    }

    // 通知观察者们
    public void notifyAll(List<Observer> observes) {
        for (Observer observer : observes) {
            observer.update();
        }
    }
}
