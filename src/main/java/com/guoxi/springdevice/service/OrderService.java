package com.guoxi.springdevice.service;

import com.guoxi.springdevice.Repository.OrderRepository;
import com.guoxi.springdevice.mapper.OrderMapper;
import com.guoxi.springdevice.mybatis.entity.OrderEntity;
import org.springframework.stereotype.Service;

/**
 * 订单service
 *
 * @author guoxi_789@126.com
 * @date 2022/6/11
 */
@Service
public class OrderService extends AbstractService<OrderEntity, OrderRepository, OrderMapper> {
}
