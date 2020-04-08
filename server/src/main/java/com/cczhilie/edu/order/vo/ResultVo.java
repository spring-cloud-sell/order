package com.cczhilie.edu.order.vo;

import lombok.Data;

/**
 * @author: GZC
 * @create: 2020-04-07 19:51
 * @description:
 **/
@Data
public class ResultVo<T> {

    private Integer code;

    private String msg;

    private T data;
}
