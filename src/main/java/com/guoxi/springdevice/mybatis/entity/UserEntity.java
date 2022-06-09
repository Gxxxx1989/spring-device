package com.guoxi.springdevice.mybatis.entity;

import com.guoxi.springdevice.common.AbstractEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * 用户实体类
 *
 * @author  guoxi@tg-hd.com
 * @since 2022/6/9 10:32
 *
 */
@Data
@Table(name = "user")
@Entity
public class UserEntity extends AbstractEntity {

    /**
     * 用户名
     */
    @Column
    private String userName;

    /**
     * 密码
     */
    @Column
    private String password;

    /**
     * 状态
     */
    @Column
    private String status;

}