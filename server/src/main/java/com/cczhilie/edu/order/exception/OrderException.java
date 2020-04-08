package com.cczhilie.edu.order.exception;

import com.cczhilie.edu.order.enums.ResultEnum;

/**
 * @author: GZC
 * @create: 2020-04-07 19:52
 * @description:
 **/
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
