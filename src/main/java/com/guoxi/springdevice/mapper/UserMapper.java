package com.guoxi.springdevice.mapper;

import com.guoxi.springdevice.mybatis.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户Mapper类
 *
 * @author guoxi@tg-hd.com
 * @since 2022/6/9 10:31
 */
@Mapper
public interface UserMapper extends AbstractMapper<UserEntity> {
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
    int insert(UserEntity record);

    /**
     * 动态插入
     *
     * @param record 记录
     * @return 插入条数
     */
    int insertSelective(UserEntity record);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 查询记录
     */
    UserEntity selectByPrimaryKey(String id);

    /**
     * 动态根据主键更新
     *
     * @param record 更新记录
     * @return 更新条数
     */
    int updateByPrimaryKeySelective(UserEntity record);


    /**
     * 根据主键更新
     *
     * @param record 更新记录
     * @return 更新条数
     */
    int updateByPrimaryKey(UserEntity record);
}