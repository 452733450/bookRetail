package com.jack.demo.service;

import com.jack.demo.dto.bizorder.req.BizOrderCreateReq;
import com.jack.demo.dto.bizorder.req.BizOrderQueryReq;
import com.jack.demo.entity.BizOrder;

import java.util.List;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/03/15/14:03
 */
public interface BizOrderService {

    void create(BizOrderCreateReq bizOrderCreateReq);

    List<BizOrder> query(BizOrderQueryReq queryReq);
}
