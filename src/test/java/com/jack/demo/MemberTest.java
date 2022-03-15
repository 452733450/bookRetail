package com.jack.demo;

import com.jack.demo.dao.MemberRepository;
import com.jack.demo.entity.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MemberTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void testGetUserByName(){
        /*Member member=memberDao.findByMemberName("jack");
        System.out.println("查询到用户名为："+member.getMemberName()+"的电话为："+member.getMobile());*/
        Member member1 = new Member();
        member1.setMembername("jack");
        List<Member> memberList = memberRepository.findAll(Example.of(member1));
        List<Member> members = memberRepository.findAll();
        System.out.println(memberList);
    }
}
