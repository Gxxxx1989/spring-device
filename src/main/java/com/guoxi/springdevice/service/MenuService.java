package com.guoxi.springdevice.service;

import com.guoxi.springdevice.Repository.MenuRepository;
import com.guoxi.springdevice.mapper.MenuMapper;
import com.guoxi.springdevice.mybatis.entity.MenuEntity;
import org.springframework.stereotype.Service;

/**
 * 菜单service
 *
 * @author guoxi_789@126.com
 * @date 2022/6/11
 */
@Service
public class MenuService extends AbstractService<MenuEntity, MenuRepository, MenuMapper> {
}
