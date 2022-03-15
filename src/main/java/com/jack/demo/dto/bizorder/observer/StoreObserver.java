package com.jack.demo.dto.bizorder.observer;

import com.jack.demo.dto.bizorder.req.BizOrderCreateReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * 库存观察者类
 */
@Slf4j
@Component
public class StoreObserver extends Observer {

    public StoreObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        log.info("开始更新库存");
        BizOrderCreateReq bizOrderCreateReq = subject.getBizOrderCreateReq();
        // ...
    }
}
