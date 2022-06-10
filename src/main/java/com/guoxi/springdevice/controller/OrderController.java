package com.guoxi.springdevice.controller;

import com.guoxi.springdevice.Repository.OrderRepository;
import com.guoxi.springdevice.mapper.OrderMapper;
import com.guoxi.springdevice.mybatis.entity.OrderEntity;
import com.guoxi.springdevice.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单控制器
 *
 * @author guoxi_789@126.com
 * @date 2022/6/11
 */

@RestController
@RequestMapping(value = "/private/api/order")
public class OrderController extends AbstractController<OrderEntity, OrderRepository, OrderMapper, OrderService> {
}
