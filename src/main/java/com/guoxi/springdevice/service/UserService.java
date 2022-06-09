package com.guoxi.springdevice.service;
import com.guoxi.springdevice.Repository.UserRepository;
import com.guoxi.springdevice.mapper.UserMapper;
import com.guoxi.springdevice.mybatis.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author guoxi@tg-hd.com
 * @since 2022/6/9$
 */
@Service
@RequiredArgsConstructor
public class UserService extends AbstractService<UserEntity, UserRepository, UserMapper> {

}
