package com.guoxi.springdevice.controller;

import com.guoxi.springdevice.Repository.UserRepository;
import com.guoxi.springdevice.mapper.UserMapper;
import com.guoxi.springdevice.mybatis.entity.UserEntity;
import com.guoxi.springdevice.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guoxi@tg-hd.com
 * @since 2022/6/10$
 */
@RestController
@RequestMapping(value = "/register")
@CrossOrigin(origins = "*")
public class RegisterController extends AbstractController<UserEntity, UserRepository, UserMapper, UserService> {
}
