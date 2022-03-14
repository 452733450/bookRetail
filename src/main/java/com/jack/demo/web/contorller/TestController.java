package com.jack.demo.web.contorller;

import com.jack.demo.dao.MemberDao;

import com.jack.demo.entity.Member;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("jack")
public class TestController {
    @Resource
    private MemberDao memberDao;

    @PostMapping("/test")
    public void test(){
        Member member=memberDao.findByMemberName("jack");
        System.out.println("查询到用户名为："+member.getMemberName()+"的电话为："+member.getMobile());
    }
}
