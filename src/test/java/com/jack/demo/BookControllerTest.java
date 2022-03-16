package com.jack.demo;

import com.alibaba.fastjson.JSON;
import com.jack.demo.dto.book.req.BookCreateReq;
import com.jack.demo.dto.book.req.BookQueryReq;
import com.jack.demo.web.contorller.BookController;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class BookControllerTest {

    private MockMvc mockMvc;

    @Resource
    private BookController bookController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    /**
     * create a book
     */
    @Test
    public void create() throws Exception {
        BookCreateReq bookCreateReq = BookCreateReq.builder()
                .bookname("红楼梦")
                .price(new BigDecimal(5))
                .store(10)
                .build();

        RequestBuilder request = post("/book/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(bookCreateReq));

        mockMvc.perform(request);
    }

    /**
     * query all books
     */
    @Test
    public void query() throws Exception {
        BookQueryReq bookQueryReq = BookQueryReq.builder().build();

        RequestBuilder request = post("/book/query")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(bookQueryReq));

        MvcResult result = mockMvc.perform(request)
                .andReturn();
        Assert.assertNotNull(result.getResponse().getContentAsString());
        log.info(result.getResponse().getContentAsString());
    }

}
