package com.guoxi.springdevice.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guoxi.springdevice.constant.ReturnStatus;
import com.guoxi.springdevice.mybatis.entity.UserEntity;
import com.guoxi.springdevice.utils.JwtUtils;
import com.guoxi.springdevice.utils.ReturnJsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static com.guoxi.springdevice.utils.JwtUtils.DEFAULT_TOKEN_TIME_MS;

/**
 * 登录成功处理
 *
 * @author guoxi@tg-hd.com
 * @since 2022/6/10 16:32
 */
@Component
@Slf4j
public class AuthSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        log.info("授权成功处理类AuthSuccessHandler--->{}", AuthSuccessHandler.class.getName());
        ObjectMapper objectMapper = new ObjectMapper();
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        UserEntity jwtUserDetails = (UserEntity) authentication.getPrincipal();
        String json = objectMapper.writeValueAsString(jwtUserDetails);
        //签发token
        String jwtToken = JwtUtils.createJwtToken(json, DEFAULT_TOKEN_TIME_MS);

        // 设置返回数据格式为 json
        httpServletResponse.setContentType("text/json;charset=utf-8");

        ReturnJsonUtil<Object> rj = new ReturnJsonUtil<>(ReturnStatus.USER_LOGIN_SUCCESS);
        rj.setData(jwtToken);
        objectMapper.writeValue(httpServletResponse.getWriter(), rj);
    }
}