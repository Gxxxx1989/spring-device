package com.guoxi.springdevice.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

import com.guoxi.springdevice.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * role
 * @author 
 */

@EqualsAndHashCode(callSuper=false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role")
public class RoleEntity extends AbstractEntity {

    /**
     * 角色名称
     */
    @Column
    private String name;

    /**
     * 角色状态
     */
    @Column
    private String status;

    /**
     * 创建时间
     */
    @Column
    private Date createTime;

    /**
     * 更新时间
     */
    @Column
    private Date updateTime;
}