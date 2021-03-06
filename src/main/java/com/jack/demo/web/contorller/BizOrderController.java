package com.jack.demo.web.contorller;

import com.jack.demo.annotation.ResponseWrapable;
import com.jack.demo.dto.bizorder.req.BizOrderCreateReq;
import com.jack.demo.dto.bizorder.req.BizOrderQueryReq;
import com.jack.demo.entity.BizOrder;
import com.jack.demo.service.BizOrderService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("bizOrder")
@Validated
public class BizOrderController {

    @Resource
    private BizOrderService bizOrderService;

    @PostMapping("/create")
    @ResponseWrapable
    public void create(@RequestBody @Valid BizOrderCreateReq bizOrderCreateReq) {
        bizOrderService.create(bizOrderCreateReq);
    }


    @PostMapping("/query")
    @ResponseWrapable
    public List<BizOrder> query(@RequestBody BizOrderQueryReq queryReq) {
        return bizOrderService.query(queryReq);
    }
}
