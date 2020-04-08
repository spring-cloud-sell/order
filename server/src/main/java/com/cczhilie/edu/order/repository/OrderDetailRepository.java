package com.cczhilie.edu.order.repository;

import com.cczhilie.edu.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: GZC
 * @create: 2020-04-07 19:39
 * @description:
 **/
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

    /**
     *根据订单ID查询订单
     * @param orderId
     * @return
     */
    List<OrderDetail> findByOrderId(String orderId);
}
