package com.jack.demo.dto.bizorder.observer;

import com.jack.demo.dao.MemberRepository;
import com.jack.demo.dao.PointRepository;
import com.jack.demo.dto.bizorder.calculate.Context;
import com.jack.demo.dto.bizorder.calculate.CoperMember;
import com.jack.demo.dto.bizorder.calculate.GoldMember;
import com.jack.demo.dto.bizorder.calculate.SilverMember;
import com.jack.demo.dto.bizorder.req.BizOrderCreateReq;
import com.jack.demo.dto.orderdetail.bo.OrderDetailBO;
import com.jack.demo.entity.Member;
import com.jack.demo.entity.Point;
import com.jack.demo.enums.YesOrNoEnum;
import com.jack.demo.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 积分观察者类
 */
@Component
@Slf4j
public class PointObserver extends Observer {

    @Resource
    private MemberRepository memberRepository;
    @Resource
    private PointRepository pointRepository;

    public PointObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update() {
        log.info("开始更新积分");
        BizOrderCreateReq bizOrderCreateReq = subject.getBizOrderCreateReq();
        Member member = memberRepository.getById(bizOrderCreateReq.getMemberid());
        Assert.notNull(member, "订单中的会员数据不存在");

        // 会员等级
        Integer memberType = member.getMembertype();
        List<OrderDetailBO> orderDetailBOList = bizOrderCreateReq.getOrderDetailBOList();
        if (CollectionUtils.isEmpty(orderDetailBOList)) {
            return;
        }

        // 订单总价
        BigDecimal totalPrice = orderDetailBOList.stream().reduce(BigDecimal.ZERO, (x, y) -> x.add(y.getPrice().multiply(new BigDecimal(y.getNum()))), BigDecimal::add);
        BigDecimal totalPoint;
        switch (memberType) {
            case 1:
                totalPoint = new Context(new CoperMember()).executeCalculate(totalPrice);
                break;
            case 2:
                totalPoint = new Context(new SilverMember()).executeCalculate(totalPrice);
                break;
            case 3:
                totalPoint = new Context(new GoldMember()).executeCalculate(totalPrice);
                break;
            default:
                throw new BizException("会员{}等级异常", memberType);
        }

        Point point = pointRepository.findByMemberid(bizOrderCreateReq.getMemberid());
        if (point != null) {
            point.setTotal(totalPoint.add(point.getTotal()));
            point.setUpdatetime(new Date());

        } else {
            point = Point.builder()
                    .memberid(bizOrderCreateReq.getMemberid())
                    .total(totalPoint)
                    .isdeleted(YesOrNoEnum.NO.getCodeValue())
                    .updatetime(new Date())
                    .createtime(new Date())
                    .build();
        }
        pointRepository.save(point);

        log.info("更新积分完成");
    }
}
