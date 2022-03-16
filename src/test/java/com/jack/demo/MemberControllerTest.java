package com.jack.demo;

import com.jack.demo.dto.member.req.MemberCreateReq;
import com.jack.demo.dto.member.req.MemberQueryReq;
import com.jack.demo.enums.MemberTypeEnum;
import com.jack.demo.enums.SexEnum;
import com.jack.demo.web.contorller.MemberController;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.alibaba.fastjson.JSON;


import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class MemberControllerTest {

    private MockMvc mockMvc;

    @Resource
    private MemberController memberController;


    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(memberController).build();
    }

    /**
     * create a member
     */
    @Test
    public void create() throws Exception {

        MemberCreateReq memberCreateReq = MemberCreateReq.builder()
                .membername("Jack")
                .membertype(MemberTypeEnum.GOLD.getCodeValue())
                .sex(SexEnum.MALE.getCodeValue())
                .age(18)
                .mobile("18013009661")
                .email("452733450@qq.com")
                .build();

        RequestBuilder request = post("/member/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(memberCreateReq));

        mockMvc.perform(request);
    }

    /**
     * query members
     *
     * @throws Exception Exception
     */
    @Test
    public void query() throws Exception {
        MemberQueryReq memberQueryReq = MemberQueryReq.builder()
                .membername("Jack")
                .build();
        RequestBuilder request = post("/member/query")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(memberQueryReq));

        MvcResult result = mockMvc.perform(request)
                .andReturn();
        Assert.assertNotNull(result.getResponse().getContentAsString());
        log.info(result.getResponse().getContentAsString());
    }
}
