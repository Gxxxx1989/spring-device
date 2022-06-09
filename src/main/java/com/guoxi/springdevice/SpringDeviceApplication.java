package com.guoxi.springdevice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 *
 * 启动类
 * EnableJpaAuditing 启用JPA注解
 *
 * @author  guoxi@tg-hd.com
 * @since 2022/6/9 17:39
 *
 */
@SpringBootApplication
@EnableJpaAuditing
public class SpringDeviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDeviceApplication.class, args);
    }

}
