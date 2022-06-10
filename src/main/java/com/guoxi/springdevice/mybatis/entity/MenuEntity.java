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
@Table(name = "menu")
public class MenuEntity extends AbstractEntity {

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单地址
     */
    private String url;


    /**
     * 父菜单
     */
    private String parentId;

}