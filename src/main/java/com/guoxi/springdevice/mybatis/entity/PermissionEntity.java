package com.guoxi.springdevice.mybatis.entity;

import com.guoxi.springdevice.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * permission
 * @author 
 */
@EqualsAndHashCode(callSuper=false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "permission")
public class PermissionEntity extends AbstractEntity {
    private String id;

    /**
     * 权限标题
     */
    @Column
    private String title;

    /**
     * 权限动作
     */
    @Column
    private String action;

    /**
     * 状态
     */
    @Column
    private String status;

}