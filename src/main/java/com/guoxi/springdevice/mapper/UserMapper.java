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

}