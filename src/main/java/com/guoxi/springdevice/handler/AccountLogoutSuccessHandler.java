package com.guoxi.springdevice.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guoxi.springdevice.constant.ReturnStatus;
import com.guoxi.springdevice.utils.ReturnJsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * 登出成功处理类
 *
 * @author  guoxi@tg-hd.com
 * @since 2022/6/10 17:02
 *
 */
@Component
@Slf4j
public class AccountLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        log.info("AccountLogoutSuccessHandler--->{}", AccountLogoutSuccessHandler.class.getName());

        httpServletResponse.setContentType("text/json;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        ReturnJsonUtil<Object> rj;
        if (authentication != null) {
            rj = new ReturnJsonUtil<>(ReturnStatus.SUCCESS);
        } else {
            rj = new ReturnJsonUtil<>(ReturnStatus.USER_NOT_LOGIN);
        }
        objectMapper.writeValue(httpServletResponse.getWriter(), rj);
    }
}