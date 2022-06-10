package com.guoxi.springdevice.service;

import com.guoxi.springdevice.Repository.AgentRepository;
import com.guoxi.springdevice.mapper.AgentMapper;
import com.guoxi.springdevice.mybatis.entity.AgentEntity;
import org.springframework.stereotype.Service;
/**
 * Agent service类
 *
 * @author guoxi_789@126.com
 * @date 2022/6/11
 */
@Service
public class AgentService extends AbstractService<AgentEntity, AgentRepository, AgentMapper> {
}
