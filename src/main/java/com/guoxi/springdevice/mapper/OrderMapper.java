package com.guoxi.springdevice.mapper;

import com.guoxi.springdevice.mybatis.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单mapper类
 *
 * @author guoxi_789@126.com
 * @date 2022/6/11
 */
@Mapper
public interface OrderMapper extends AbstractMapper<OrderEntity> {
}
