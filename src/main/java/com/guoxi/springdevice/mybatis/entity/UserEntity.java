package com.guoxi.springdevice.mybatis.entity;

import com.guoxi.springdevice.common.AbstractEntity;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Collection;

/**
 *
 * 用户实体类
 *
 * @author  guoxi@tg-hd.com
 * @since 2022/6/9 10:32
 *
 */
@Data
@Table(name = "user")
@Entity
public class UserEntity extends AbstractEntity implements UserDetails {

    /**
     * 用户名
     */
    @Column
    private String userName;

    /**
     * 密码
     */
    @Column
    private String password;

    /**
     * 状态
     */
    @Column
    private String status;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}