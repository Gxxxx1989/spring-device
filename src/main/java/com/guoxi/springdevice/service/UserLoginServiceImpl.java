package com.guoxi.springdevice.service;

import com.guoxi.springdevice.Repository.UserRepository;
import com.guoxi.springdevice.mybatis.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 用户登录处理类
 * @author guoxi@tg-hd.com
 * @since 2022/6/10$
 */
@Service
@RequiredArgsConstructor
public class UserLoginServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //1、校验用户信息
        UserEntity userEntity = userRepository.findByUsername(userName);
        if (userEntity == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return userEntity;
    }
}
