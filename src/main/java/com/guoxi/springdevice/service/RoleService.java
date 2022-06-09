package com.guoxi.springdevice.service;

import com.guoxi.springdevice.Repository.RoleRepository;
import com.guoxi.springdevice.mapper.RoleMapper;
import com.guoxi.springdevice.mybatis.entity.RoleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author guoxi@tg-hd.com
 * @since 2022/6/9$
 */

@Service
@RequiredArgsConstructor
public class RoleService extends AbstractService<RoleEntity, RoleRepository, RoleMapper> {
}
