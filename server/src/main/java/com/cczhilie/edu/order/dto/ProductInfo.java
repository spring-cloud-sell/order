package com.cczhilie.edu.order.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: GZC
 * @create: 2020-04-07 15:04
 * @description: 商品实体类
 **/
@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;

    /** 名字. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 状态, 0正常1下架. */
    private Integer productStatus;

    /** 类目编号. */
    private Integer categoryType;

    /** 创建日期. */
    private Date createTime;

    /** 更新日期. */
    private Date updateTime;


}
