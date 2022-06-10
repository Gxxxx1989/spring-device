package com.guoxi.springdevice.controller;

import com.guoxi.springdevice.Repository.PermissionRepository;
import com.guoxi.springdevice.mapper.PermissionMapper;
import com.guoxi.springdevice.mybatis.entity.PermissionEntity;
import com.guoxi.springdevice.service.PermissionService;
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
@RequestMapping(value = "/api/Permission")
@CrossOrigin(origins = "*")
public class PermissionController extends AbstractController<PermissionEntity, PermissionRepository, PermissionMapper, PermissionService> {
}
