package com.guoxi.springdevice.controller;

import com.guoxi.springdevice.Repository.MachineInfoRepository;
import com.guoxi.springdevice.mapper.MachineInfoMapper;
import com.guoxi.springdevice.mybatis.entity.MachineInfoEntity;
import com.guoxi.springdevice.service.MachineInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 设备控制器类
 *
 * @author guoxi_789@126.com
 * @date 2022/6/14
 */
@RestController
@RequestMapping(value = "/private/api/machine")
public class MachineInfoController extends AbstractController<MachineInfoEntity, MachineInfoRepository, MachineInfoMapper, MachineInfoService> {
}
