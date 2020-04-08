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
import com.cczhilie.edu.product.client.ProductClient;
import com.cczhilie.edu.product.common.DecreaseStockInput;
import com.cczhilie.edu.product.common.ProductInfoOutput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    private ProductClient productClient;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtil.genUniqueKey();

        //查询商品信息(调用商品服务)
        List<String> productIdList = orderDTO.getOrderDetailList()
                .stream()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        List<ProductInfoOutput> productInfoOutputList = productClient.listForOrder(productIdList);

        BigDecimal totalQuantity = new BigDecimal(BigInteger.ZERO);
        //计算总价
        for (OrderDetail orderDetail:orderDTO.getOrderDetailList()) {
            for (ProductInfoOutput productInfo:productInfoOutputList) {
                if (orderDetail.getProductId().equals(productInfo.getProductId())){
                    totalQuantity = totalQuantity.add(productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())));
                    BeanUtils.copyProperties(productInfo,orderDetail);
                    orderDetail.setDetailId(KeyUtil.genUniqueKey());
                    orderDetail.setOrderId(orderId);
                    orderDetailRepository.save(orderDetail);
                }
            }

        }


        //扣库存(调用商品服务)
        List<DecreaseStockInput> decreaseStockInputList = orderDTO.getOrderDetailList()
                .stream()
                .map(e -> new DecreaseStockInput(e.getProductId(),e.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(decreaseStockInputList);


        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(totalQuantity);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
