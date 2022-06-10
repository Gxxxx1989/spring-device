package com.guoxi.springdevice.controller;

import com.guoxi.springdevice.Repository.StoreRepository;
import com.guoxi.springdevice.mapper.StoreMapper;
import com.guoxi.springdevice.mybatis.entity.StoreEntity;
import com.guoxi.springdevice.service.StoreService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 门店控制器类
 *
 * @author guoxi_789@126.com
 * @date 2022/6/11
 */
@RestController
@RequestMapping(value = "/private/api/store")
public class StoreController extends AbstractController<StoreEntity, StoreRepository, StoreMapper, StoreService> {
}
