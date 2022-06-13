package com.guoxi.springdevice.service;

import com.guoxi.springdevice.Repository.StoreRepository;
import com.guoxi.springdevice.mapper.StoreMapper;
import com.guoxi.springdevice.mybatis.entity.StoreEntity;
import org.springframework.stereotype.Service;

/**
 * Store 门店service类
 *
 * @author guoxi_789@126.com
 * @date 2022/6/11
 */
@Service
public class StoreService extends AbstractService<StoreEntity, StoreRepository, StoreMapper> {
}
