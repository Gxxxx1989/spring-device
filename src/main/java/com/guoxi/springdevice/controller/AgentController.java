package com.guoxi.springdevice.controller;

import com.guoxi.springdevice.Repository.AgentRepository;
import com.guoxi.springdevice.mapper.AgentMapper;
import com.guoxi.springdevice.mybatis.entity.AgentEntity;
import com.guoxi.springdevice.service.AgentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 代理商控制器类
 *
 * @author guoxi_789@126.com
 * @date 2022/6/11
 */
@RestController
@RequestMapping(value = "/private/api/agent")
public class AgentController extends AbstractController<AgentEntity, AgentRepository, AgentMapper, AgentService> {
}
