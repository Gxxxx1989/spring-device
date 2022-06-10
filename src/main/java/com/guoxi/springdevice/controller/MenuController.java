package com.guoxi.springdevice.controller;

import com.guoxi.springdevice.Repository.MenuRepository;
import com.guoxi.springdevice.mapper.MenuMapper;
import com.guoxi.springdevice.mybatis.entity.MenuEntity;
import com.guoxi.springdevice.service.MenuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 菜单控制器
 *
 * @author guoxi_789@126.com
 * @date 2022/6/11
 */
@RestController
@RequestMapping(value = "/private/api/menu")
public class MenuController extends AbstractController<MenuEntity, MenuRepository, MenuMapper, MenuService> {
}
