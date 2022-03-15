package com.jack.demo.service.impl;

import com.jack.demo.dao.PointRepository;
import com.jack.demo.entity.Point;
import com.jack.demo.service.PointService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class PointServiceImpl implements PointService {

    @Resource
    private PointRepository pointRepository;

    @Override
    public List<Point> query() {
        return pointRepository.findAll();
    }
}
