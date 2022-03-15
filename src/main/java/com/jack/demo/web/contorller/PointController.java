package com.jack.demo.web.contorller;

import com.jack.demo.annotation.ResponseWrapable;
import com.jack.demo.dto.member.req.MemberCreateReq;
import com.jack.demo.entity.Point;
import com.jack.demo.service.MemberService;
import com.jack.demo.service.PointService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("point")
@Validated
public class PointController {

    @Resource
    private PointService pointService;

    @PostMapping("/create")
    @ResponseWrapable
    public void create() {

    }

    @PostMapping("/query")
    @ResponseWrapable
    public List<Point> query(){
        return pointService.query();
    }

}
