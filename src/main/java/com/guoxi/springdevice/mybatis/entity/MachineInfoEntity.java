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
 * 设备实体类
 *
 * @author guoxi_789@126.com
 * @date 2022/6/14
 */
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "machine_info")
public class MachineInfoEntity extends AbstractEntity {

    /**
     * 类型
     */
    @Column
    private String machineType;

    /**
     * 功能
     */
    @Column
    private String machineFunction;

    /**
     * 参数
     */
    @Column
    private String machineParam;

    /**
     * 属性
     */
    @Column
    private String machineAttribute;

    /**
     * 用户id
     */
    @Column
    private String userId;

    /**
     * 使用时长
     */
    @Column
    private Integer usedDuration;

    /**
     * 品牌
     */
    @Column
    private String machineBrand;

    /**
     * 设备状态
     */
    @Column
    private String machineStatus;

    /**
     * 单次使用时长
     */
    @Column
    private Integer machineWorkTimeOnce;

    /**
     * 省份名称
     */
    @Column
    private String machineProvince;

    /**
     * 城市名称
     */
    @Column
    private String machineCity;

    /**
     * 合作方式
     */
    @Column
    private String cooperationMode;

    /**
     * 城市id
     */
    @Column
    private String machineCityId;

    /**
     * 省份id
     */
    @Column
    private String machineProvinceId;

    /**
     * 在线状态
     */
    @Column
    private Integer onlineStatus;

    /**
     * 最后登录时间
     */
    @Column
    private Date lastLoginTime;

    /**
     * 锁定状态
     */
    @Column
    private Integer lockStatus;

    /**
     * 其他参数
     */
    @Column
    private String otherParam;


}