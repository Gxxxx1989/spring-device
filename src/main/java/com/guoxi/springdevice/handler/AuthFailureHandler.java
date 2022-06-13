package com.guoxi.springdevice.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guoxi.springdevice.constant.ReturnStatus;
import com.guoxi.springdevice.utils.ReturnJsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录失败处理类
 *
 * @author guoxi@tg-hd.com
 * @since 2022/6/10 16:37
 */
@Component
@Slf4j
public class AuthFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        log.info("授权失败处理类AuthFailureHandler--->{}", AuthFailureHandler.class.getName());

        ReturnJsonUtil<Object> rj = null;
        if (e instanceof AccountExpiredException) {
            //账号过期
            rj = new ReturnJsonUtil<>(ReturnStatus.USER_ACCOUNT_EXPIRED);
        } else if (e instanceof BadCredentialsException) {
            //密码错误
            rj = new ReturnJsonUtil<>(ReturnStatus.USER_PASSWORD_ERROR);
        } else if (e instanceof CredentialsExpiredException) {
            //密码过期
            rj = new ReturnJsonUtil<>(ReturnStatus.USER_PASSWORD_EXPIRED);
        } else if (e instanceof DisabledException) {
            //账号不可用
            rj = new ReturnJsonUtil<>(ReturnStatus.USER_ACCOUNT_DISABLE);
        } else if (e instanceof LockedException) {
            //账号锁定
            rj = new ReturnJsonUtil<>(ReturnStatus.USER_ACCOUNT_LOCKED);
        } else if (e instanceof InternalAuthenticationServiceException) {
            //用户不存在
            rj = new ReturnJsonUtil<>(ReturnStatus.USER_ACCOUNT_NOT_EXIST);
        } else {
            //其他错误
            rj = new ReturnJsonUtil<>(ReturnStatus.COMMON_ERROR);
        }
        httpServletResponse.setContentType("text/json;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(httpServletResponse.getWriter(), rj);
    }
}