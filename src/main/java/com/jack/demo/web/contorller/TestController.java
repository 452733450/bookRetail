package com.jack.demo.web.contorller;

import com.jack.demo.annotation.ResponseWrapable;
import com.jack.demo.dao.MemberDao;

import com.jack.demo.dto.member.req.MemberCreateReq;
import com.jack.demo.entity.Member;
import com.jack.demo.service.MemberService;
import org.springframework.data.domain.Example;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("test")
@Validated
public class TestController {
    @Resource
    private MemberDao memberDao;

    @Resource
    private MemberService memberService;

    @PostMapping("/test")
    public void test() {
        Member member1 = new Member();
        member1.setMembername("jack");
        memberDao.save(member1);
    }

    @PostMapping("/test2")
    public void test2() {
        /*Member member=memberDao.findByMemberName("jack");
        System.out.println("查询到用户名为："+member.getMemberName()+"的电话为："+member.getMobile());*/

        Member member1 = new Member();
        member1.setMembername("jack");
        List<Member> memberList = memberDao.findAll(Example.of(member1));
        List<Member> memberList1 = memberDao.findAll();
        System.out.println(memberList);
    }

    @PostMapping("/create")
    @ResponseWrapable
    public void create(@RequestBody @Valid MemberCreateReq memberCreateReq) {
        memberService.create(memberCreateReq);
    }
}
