package com.jack.demo;

import com.jack.demo.web.contorller.PointController;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class PointControllerTest {
    private MockMvc mockMvc;

    @Resource
    private PointController pointController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(pointController).build();
    }

    /**
     * query member's points
     */
    @Test
    public void query() throws Exception {
        RequestBuilder request = post("/point/query")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();
        Assert.assertNotNull(result.getResponse().getContentAsString());
        log.info(result.getResponse().getContentAsString());
    }
}
