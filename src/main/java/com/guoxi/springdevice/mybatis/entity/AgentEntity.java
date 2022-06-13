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
 *
 *
 * @author guoxi_789@126.com
 * @date 2022/6/11
 */
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "agent")
public class AgentEntity extends AbstractEntity {
    /**
     * 代理商户名称
     */
    @Column
    private String name;

    /**
     * 代理商编码
     */
    @Column
    private String code;

    /**
     * 代理商地址
     */
    @Column
    private String address;

    /**
     * 联系人
     */
    @Column
    private String contactPerson;

    /**
     * 设备数量
     */
    @Column
    private Integer deviceCount;

}
