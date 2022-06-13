package com.guoxi.springdevice.mapper;

import com.guoxi.springdevice.mybatis.entity.MachineInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 设备Mapper类
 *
 * @author guoxi_789@126.com
 * @date 2022/6/14
 */
@Mapper
public interface MachineInfoMapper extends AbstractMapper<MachineInfoEntity> {

    /**
     * 根据主键删除
     *
     * @param id 主键
     * @return 删除条数
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入记录
     *
     * @param record 记录
     * @return 插入记录条数
     */
    int insert(MachineInfoEntity record);

    /**
     * 动态插入
     *
     * @param record 记录
     * @return 插入条数
     */
    int insertSelective(MachineInfoEntity record);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 查询记录
     */
    MachineInfoEntity selectByPrimaryKey(String id);

    /**
     * 动态根据主键更新
     *
     * @param record 更新记录
     * @return 更新条数
     */
    int updateByPrimaryKeySelective(MachineInfoEntity record);


    /**
     * 根据主键更新
     *
     * @param record 更新记录
     * @return 更新条数
     */
    int updateByPrimaryKey(MachineInfoEntity record);
}