package com.jack.demo.web.contorller;

import com.jack.demo.annotation.ResponseWrapable;
import com.jack.demo.dao.MemberDao;
import com.jack.demo.dto.member.req.MemberCreateReq;
import com.jack.demo.dto.member.req.MemberQueryReq;
import com.jack.demo.dto.member.rsp.MemberQueryRsp;
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
@RequestMapping("member")
@Validated
public class MemberController {

    @Resource
    private MemberService memberService;

    @PostMapping("/create")
    @ResponseWrapable
    public void create(@RequestBody @Valid MemberCreateReq memberCreateReq) {
        memberService.create(memberCreateReq);
    }


    @PostMapping("/query")
    @ResponseWrapable
    public List<MemberQueryRsp> query(@RequestBody @Valid MemberQueryReq memberQueryReq) {
        return memberService.query(memberQueryReq);
    }

}
