package com.guoxi.springdevice.controller;

import com.guoxi.springdevice.Repository.RoleRepository;
import com.guoxi.springdevice.mapper.RoleMapper;
import com.guoxi.springdevice.mybatis.entity.RoleEntity;
import com.guoxi.springdevice.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guoxi@tg-hd.com
 * @since 2022/6/9$
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/role")
@CrossOrigin(origins = "*")
public class RoleController extends AbstractController<RoleEntity, RoleRepository, RoleMapper, RoleService> {
}
