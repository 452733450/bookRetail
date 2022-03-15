package com.jack.demo.dao;

import com.jack.demo.dto.member.req.MemberQueryReq;
import com.jack.demo.dto.member.rsp.MemberQueryRsp;
import com.jack.demo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MemberDao extends JpaRepository<Member,Long> {
    Member findByMembername(String name);
}
