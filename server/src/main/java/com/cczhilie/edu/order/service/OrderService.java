package com.cczhilie.edu.order.service;

import com.cczhilie.edu.order.dto.OrderDTO;

/**
 * @author: GZC
 * @create: 2020-04-07 19:41
 * @description:
 **/
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 完成订单
     * @param orderId
     * @return
     */
    OrderDTO finish(String orderId);

}
