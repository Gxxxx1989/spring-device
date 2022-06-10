package com.guoxi.springdevice.controller;

import com.guoxi.springdevice.Repository.UserRepository;
import com.guoxi.springdevice.mapper.UserMapper;
import com.guoxi.springdevice.mybatis.entity.UserEntity;
import com.guoxi.springdevice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author guoxi@tg-hd.com
 * @since 2022/6/9$
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/user")
@CrossOrigin(origins = "*")
public class UserController extends AbstractController<UserEntity, UserRepository, UserMapper, UserService> {


}
