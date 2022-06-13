package com.guoxi.springdevice.service;

import com.guoxi.springdevice.Repository.PermissionRepository;
import com.guoxi.springdevice.mapper.PermissionMapper;
import com.guoxi.springdevice.mybatis.entity.PermissionEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author guoxi@tg-hd.com
 * @since 2022/6/9$
 */
@Service
@RequiredArgsConstructor
public class PermissionService extends AbstractService<PermissionEntity, PermissionRepository, PermissionMapper>{
}
