package com.jack.demo;

import com.alibaba.fastjson.JSON;
import com.jack.demo.dto.bizorder.req.BizOrderCreateReq;
import com.jack.demo.dto.bizorder.req.BizOrderQueryReq;
import com.jack.demo.dto.orderdetail.bo.OrderDetailBO;
import com.jack.demo.web.contorller.BizOrderController;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class BizOrderControllerTest {
    private MockMvc mockMvc;

    @Resource
    private BizOrderController bizOrderController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(bizOrderController).build();
    }

    /**
     * create a bizOrder
     */
    @Test
    public void create() throws Exception {
        OrderDetailBO orderDetailBO = OrderDetailBO.builder()
                .bookid(1L)
                .num(1)
                .price(new BigDecimal(5))
                .build();
        List<OrderDetailBO> orderDetails = new ArrayList<>();
        orderDetails.add(orderDetailBO);

        BizOrderCreateReq bizOrderCreateReq = BizOrderCreateReq.builder()
                .memberid(1L)
                .orderDetailBOList(orderDetails)
                .build();

        RequestBuilder request = post("/bizOrder/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(bizOrderCreateReq));

        mockMvc.perform(request);
    }

    /**
     * query bizOrders
     */
    @Test
    public void query() throws Exception {
        BizOrderQueryReq bizOrderQueryReq = BizOrderQueryReq.builder()
                /*.id(1L)*/
                .build();

        RequestBuilder request = post("/bizOrder/query")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(bizOrderQueryReq));

        MvcResult result = mockMvc.perform(request)
                .andReturn();
        Assert.assertNotNull(result.getResponse().getContentAsString());
        log.info(result.getResponse().getContentAsString());
    }
}
