package com.cczhilie.edu.order.controller;

import com.cczhilie.edu.order.converter.OrderForm2OrderDTOConverter;
import com.cczhilie.edu.order.dto.OrderDTO;
import com.cczhilie.edu.order.enums.ResultEnum;
import com.cczhilie.edu.order.exception.OrderException;
import com.cczhilie.edu.order.form.OrderForm;
import com.cczhilie.edu.order.service.OrderService;
import com.cczhilie.edu.order.utils.ResultVoUtil;
import com.cczhilie.edu.order.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: GZC
 * @create: 2020-04-07 19:35
 * @description:
 **/
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 1. 参数检验
     * 2. 查询商品信息(调用商品服务)
     * 3. 计算总价
     * 4. 扣库存(调用商品服务)
     * 5. 订单入库
     */
    @PostMapping("/create")
    public ResultVo<Map<String, String>> create(@Valid OrderForm orderForm,
                                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确, orderForm={}", orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        // orderForm -> orderDTO
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车信息为空");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }

        OrderDTO result = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());
        return ResultVoUtil.success(map);
    }

    /**
     * 完结订单
     * @param orderId
     * @return
     */
    @PostMapping("/finish")
    public ResultVo<OrderDTO> finish(@RequestParam("orderId") String orderId) {
        return ResultVoUtil.success(orderService.finish(orderId));
    }
}
