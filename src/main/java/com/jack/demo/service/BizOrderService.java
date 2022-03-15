package com.jack.demo.service;

import com.jack.demo.dto.bizorder.req.BizOrderCreateReq;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/03/15/14:03
 */
public interface BizOrderService {

    void create(BizOrderCreateReq bizOrderCreateReq);

    void query();
}
