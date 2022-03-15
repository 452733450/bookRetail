package com.jack.demo.dao;

import com.jack.demo.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PointRepository extends JpaRepository<Point,Long> {

    Point findByMemberid(Long memberid);
}
