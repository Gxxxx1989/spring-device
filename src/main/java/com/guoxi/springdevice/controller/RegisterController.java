package com.guoxi.springdevice.controller;
import com.guoxi.springdevice.mybatis.entity.UserEntity;
import com.guoxi.springdevice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author guoxi@tg-hd.com
 * @since 2022/6/10$
 */
@RestController
@RequestMapping(value = "/api/register")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RegisterController {

    private final UserService userService;

    @PostMapping(value = "/registerUser")
    public Boolean registerUser(@RequestBody UserEntity userEntity) {
        return userService.saveOrUpdateData(userEntity) != null;
    }
}
