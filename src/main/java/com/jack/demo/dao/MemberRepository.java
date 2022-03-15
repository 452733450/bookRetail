package com.jack.demo.dao;

import com.jack.demo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    Member findByMembername(String name);
}
