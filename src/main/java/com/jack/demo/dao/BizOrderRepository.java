package com.jack.demo.dao;

import com.jack.demo.entity.BizOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BizOrderRepository extends JpaRepository<BizOrder,Long> {
}
