package com.guoxi.springdevice.mybatis.entity;


import com.guoxi.springdevice.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 门店实体类
 *
 * @author guoxi_789@126.com
 * @date 2022/6/11
 */
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "store")
public class StoreEntity extends AbstractEntity {

    /**
     * 门店编码
     */
    @Column
    private String code;

    /**
     * 门店地址
     */
    @Column
    private String address;

    /**
     * 联系人
     */
    @Column
    private String contactPerson;

    /**
     * 所属代理商id
     */
    @Column
    private String agentId;

    /**
     * 设备数量
     */
    @Column
    private Integer deviceCount;

}
