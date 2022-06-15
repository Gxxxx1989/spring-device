package com.guoxi.springdevice.Repository;

import com.guoxi.springdevice.mybatis.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author guoxi@tg-hd.com
 * @since 2022/6/9$
 */
@Repository
public interface UserRepository extends AbstractRepository<UserEntity>{
    /**
     * 根据用户名查用户信息
     * @param userName 用户名
     * @return 用户实体类信息
     */
    UserEntity findByUsername(String  userName);
}
