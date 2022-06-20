package com.guoxi.springdevice.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guoxi.springdevice.constant.ReturnStatus;
import com.guoxi.springdevice.utils.ReturnJsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * 匿名访问（未登录访问）处理器
 *
 * @author  guoxi@tg-hd.com
 * @since 2022/6/10 17:06
 *
 */
@Component
@Slf4j
public class AuthEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        log.info("异常处理类AuthEntryPoint--->{}", AuthEntryPoint.class.getName());

        ReturnJsonUtil<Object> rj = new ReturnJsonUtil<>(ReturnStatus.USER_UN_AUTH);
        rj.setStatusMsg(e.getMessage());
        httpServletResponse.setContentType("text/json;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(httpServletResponse.getWriter(), rj);
    }
}