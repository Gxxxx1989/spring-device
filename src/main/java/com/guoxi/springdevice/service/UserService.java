package com.guoxi.springdevice.service;

import com.guoxi.springdevice.Repository.UserRepository;
import com.guoxi.springdevice.mapper.UserMapper;
import com.guoxi.springdevice.mybatis.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author guoxi@tg-hd.com
 * @since 2022/6/9$
 */
@Service
@RequiredArgsConstructor
public class UserService extends AbstractService<UserEntity, UserRepository, UserMapper> implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public UserEntity saveOrUpdateData(UserEntity entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return super.saveOrUpdateData(entity);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //1、校验用户信息
        UserEntity userEntity = userRepository.findByUserName(userName);
        if (userEntity==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        return userEntity;
    }
}
