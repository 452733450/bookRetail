package com.jack.demo.service;

import com.jack.demo.dto.member.req.MemberCreateReq;
import com.jack.demo.dto.member.req.MemberQueryReq;
import com.jack.demo.dto.member.rsp.MemberQueryRsp;

import java.util.List;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/03/15/14:03
 */
public interface MemberService {

    void create(MemberCreateReq memberCreateReq);

    List<MemberQueryRsp> query(MemberQueryReq memberQueryReq);
}
