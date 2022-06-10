package com.guoxi.springdevice.mybatis.entity;


import com.guoxi.springdevice.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * 订单实体类
 *
 * @author guoxi_789@126.com
 * @date 2022/6/11
 */
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order")
public class OrderEntity extends AbstractEntity {

    /**
     * 订单号
     */
    @Column
    private String orderNo;

    /**
     * 订单内容
     */
    @Column
    private String orderContent;

    /**
     * 订单价格
     */
    @Column
    private BigDecimal price;

    /**
     * 付款状态
     */
    @Column
    private String payStatus;

    /**
     * 订单状态
     */
    @Column
    private String orderStatus;


}
