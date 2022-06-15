package com.guoxi.springdevice.service;

import com.guoxi.springdevice.Repository.UserRepository;
import com.guoxi.springdevice.exception.UsernameAlreadyExistsException;
import com.guoxi.springdevice.mapper.UserMapper;
import com.guoxi.springdevice.mybatis.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 用户操作处理类
 *
 * @author guoxi@tg-hd.com
 * @since 2022/6/9$
 */
@Service
@RequiredArgsConstructor
public class UserService extends AbstractService<UserEntity, UserRepository, UserMapper> {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    /**
     * 新增用户时加密处理、用户名校验
     *
     * @param entity 用户实体类
     * @return 用户信息
     */
    @Override
    public UserEntity saveOrUpdateData(UserEntity entity) {
        if (StringUtils.isBlank(entity.getId())) {
            entity.setPassword(passwordEncoder.encode(entity.getPassword()));
            UserEntity userEntity = userRepository.findByUsername(entity.getUsername());
            if (userEntity != null) {
                throw new UsernameAlreadyExistsException("用户名已经存在！");
            }
        }
        return super.saveOrUpdateData(entity);
    }

}
