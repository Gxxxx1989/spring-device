package com.guoxi.springdevice.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guoxi.springdevice.constant.ReturnStatus;
import com.guoxi.springdevice.utils.ReturnJsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 拒绝访问处理类
 *
 * @author guoxi@tg-hd.com
 * @since 2022/6/10 19:32
 */
@Component
@Slf4j
public class CustomizeAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        log.info("拒绝访问处理类CustomizeAccessDeniedHandler--->{}", CustomizeAccessDeniedHandler.class.getName());

        // 设置返回数据格式为 json
        httpServletResponse.setContentType("text/json;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        ReturnJsonUtil<Object> rj = new ReturnJsonUtil<>(ReturnStatus.SUCCESS);
        objectMapper.writeValue(httpServletResponse.getWriter(), rj);
    }
}