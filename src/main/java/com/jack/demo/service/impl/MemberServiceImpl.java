package com.jack.demo.service.impl;

import com.jack.demo.dao.MemberRepository;
import com.jack.demo.dto.member.req.MemberCreateReq;
import com.jack.demo.dto.member.req.MemberQueryReq;
import com.jack.demo.dto.member.rsp.MemberQueryRsp;
import com.jack.demo.entity.Member;
import com.jack.demo.service.MemberService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/03/15/14:03
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Resource
    MemberRepository memberRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(MemberCreateReq memberCreateReq) {
        Member member = new Member();
        BeanUtils.copyProperties(memberCreateReq, member);
        memberRepository.save(member);
    }

    @Override
    public List<MemberQueryRsp> query(MemberQueryReq memberQueryReq) {
        Member member = new Member();
        BeanUtils.copyProperties(memberQueryReq, member);
        List<Member> members = memberRepository.findAll(Example.of(member));
        List<MemberQueryRsp> res = new ArrayList<>();
        members.forEach(m -> {
            MemberQueryRsp m1 = new MemberQueryRsp();
            BeanUtils.copyProperties(m, m1);
            res.add(m1);
        });
        return res;
    }
}
