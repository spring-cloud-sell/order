package com.cczhilie.edu.order.repository;

import com.cczhilie.edu.order.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: GZC
 * @create: 2020-04-07 19:40
 * @description:
 **/
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {

}
