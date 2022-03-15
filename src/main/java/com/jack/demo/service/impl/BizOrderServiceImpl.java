package com.jack.demo.service.impl;

import com.jack.demo.dao.BizOrderRepository;
import com.jack.demo.dao.BookRepository;
import com.jack.demo.dao.MemberRepository;
import com.jack.demo.dao.OrderDetailRepository;
import com.jack.demo.dto.bizorder.observer.Subject;
import com.jack.demo.dto.bizorder.req.BizOrderCreateReq;
import com.jack.demo.dto.orderdetail.bo.OrderDetailBO;
import com.jack.demo.entity.BizOrder;
import com.jack.demo.entity.Book;
import com.jack.demo.entity.Member;
import com.jack.demo.entity.OrderDetail;
import com.jack.demo.enums.YesOrNoEnum;
import com.jack.demo.exception.BizException;
import com.jack.demo.service.BizOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;


@Service
@Slf4j
public class BizOrderServiceImpl implements BizOrderService {

    @Resource
    private BizOrderRepository bizOrderRepository;
    @Resource
    private OrderDetailRepository orderDetailRepository;
    @Resource
    private Subject subject;
    @Resource
    private MemberRepository memberRepository;
    @Resource
    private BookRepository bookRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(BizOrderCreateReq bizOrderCreateReq) {
        // 校验会员是否存在
        this.checkMember(bizOrderCreateReq.getMemberid());
        // 校验订单中的书籍是否存在
        this.checkBooks(bizOrderCreateReq.getOrderDetailBOList().stream().map(OrderDetailBO::getBookid).collect(Collectors.toSet()));

        // 订单号
        String orderNo = UUID.randomUUID().toString();
        List<OrderDetailBO> orderDetailBOS = bizOrderCreateReq.getOrderDetailBOList();
        // 订单总价
        BigDecimal total = orderDetailBOS.stream().reduce(BigDecimal.ZERO, (x, y) -> x.add(y.getPrice().multiply(new BigDecimal(y.getNum()))), BigDecimal::add);

        // 保存订单
        BizOrder bizOrder = BizOrder.builder()
                .orderno(orderNo)
                .memberid(bizOrderCreateReq.getMemberid())
                .total(total)
                .isdelete(YesOrNoEnum.NO.getCodeValue())
                .updatetime(new Date())
                .createtime(new Date())
                .build();
        BizOrder entity = bizOrderRepository.save(bizOrder);

        // 保存订单详情
        Long bizOrderId = entity.getId();
        List<OrderDetail> orderDetails = new ArrayList<>();
        orderDetailBOS.forEach(orderDetailBO -> {
            OrderDetail orderDetail = OrderDetail.builder()
                    .bizorderid(bizOrderId)
                    .orderno(orderNo)
                    .memberid(bizOrderCreateReq.getMemberid())
                    .bookid(orderDetailBO.getBookid())
                    .num(orderDetailBO.getNum())
                    .price(orderDetailBO.getPrice())
                    .total(orderDetailBO.getPrice().multiply(new BigDecimal(orderDetailBO.getNum())))
                    .isdelete(YesOrNoEnum.NO.getCodeValue())
                    .updatetime(new Date())
                    .createtime(new Date())
                    .build();
            orderDetails.add(orderDetail);
        });
        orderDetailRepository.saveAll(orderDetails);

        // 订单创建后通知观察者们(更新积分、扣减库存)
        subject.setBizOrderCreateReq(bizOrderCreateReq);
    }

    @Override
    public void query() {
        List<BizOrder> bizOrders = bizOrderRepository.findAll();
        List<OrderDetail> orderDetails = orderDetailRepository.findAll();
        log.info("查询结束");
    }

    private void checkMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElse(null);
        if (Objects.isNull(member)) {
            throw new BizException("会员不存在，请先创建会员");
        }
    }

    private void checkBooks(Set<Long> bookIds) {
        List<Book> books = bookRepository.findAllById(bookIds);
        if (CollectionUtils.isEmpty(books)) {
            throw new BizException("订单中的书籍全部不存在，请正确填写订单");
        }
        Set<Long> bookIdsRes = books.stream().map(Book::getId).collect(Collectors.toSet());
        if (bookIds.size() != bookIdsRes.size()) {
            throw new BizException("订单中的有不存在的书籍，请正确填写订单");
        }
    }
}
