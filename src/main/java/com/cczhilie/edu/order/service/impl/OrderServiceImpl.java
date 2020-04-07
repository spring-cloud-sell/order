package com.cczhilie.edu.order.service.impl;

import com.cczhilie.edu.order.dataobject.OrderDetail;
import com.cczhilie.edu.order.dataobject.OrderMaster;
import com.cczhilie.edu.order.dto.OrderDTO;
import com.cczhilie.edu.order.enums.OrderStatusEnum;
import com.cczhilie.edu.order.enums.PayStatusEnum;
import com.cczhilie.edu.order.repository.OrderDetailRepository;
import com.cczhilie.edu.order.repository.OrderMasterRepository;
import com.cczhilie.edu.order.service.OrderService;
import com.cczhilie.edu.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author: GZC
 * @create: 2020-04-07 19:41
 * @description:
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtil.genUniqueKey();

        //查询商品信息(调用商品服务)

        //计算总价

        //扣库存(调用商品服务)


        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(55));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
