package com.cczhilie.edu.order.enums;

import lombok.Getter;

/**
 * @author: GZC
 * @create: 2020-04-07 19:45
 * @description:
 **/
@Getter
public enum OrderStatusEnum {
    /**
     * 新订单
     */
    NEW(0, "新订单"),

    /**
     * 完结
     */
    FINISHED(1, "完结"),

    /**
     * 取消
     */
    CANCEL(2, "取消"),
    ;
    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
