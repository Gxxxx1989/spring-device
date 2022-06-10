package com.guoxi.springdevice.exception;


import lombok.Getter;

import java.util.function.Supplier;

/**
 * 自定义用户存在异常
 * @author guoxi@tg-hd.com
 * @since 2022/6/10$
 */
@Getter
public class UsernameAlreadyExistsException extends RuntimeException implements Supplier<UsernameAlreadyExistsException> {

    public UsernameAlreadyExistsException(String message) {
        super(message);
    }

    /**
     * Gets a result.
     *
     * @return a result
     */
    @Override
    public UsernameAlreadyExistsException get() {
        return this;
    }
}
