package com.cczhilie.edu.order.dto;

import lombok.Data;

/**
 * @author: GZC
 * @create: 2020-04-08 16:58
 * @description:
 **/
@Data
public class CartDTO {
    /**
     * 商品id
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
