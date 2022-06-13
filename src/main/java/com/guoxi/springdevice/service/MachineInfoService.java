package com.guoxi.springdevice.service;

import com.guoxi.springdevice.Repository.MachineInfoRepository;
import com.guoxi.springdevice.mapper.MachineInfoMapper;
import com.guoxi.springdevice.mybatis.entity.MachineInfoEntity;
import org.springframework.stereotype.Service;

/**
 * 设备service类
 *
 * @author guoxi_789@126.com
 * @date 2022/6/14
 */
@Service
public class MachineInfoService extends AbstractService<MachineInfoEntity, MachineInfoRepository, MachineInfoMapper> {

}
