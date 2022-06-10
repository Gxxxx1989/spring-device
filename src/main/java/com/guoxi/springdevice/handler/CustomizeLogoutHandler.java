package com.guoxi.springdevice.handler;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 注销出处理类
 *
 * @author guoxi_789@126.com
 * @date 2022/6/11
 */
@Component
@Slf4j
public class CustomizeLogoutHandler implements LogoutHandler {
    @Override
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
        log.info("注销处理类CustomizeLogoutHandler--->{}", CustomizeLogoutHandler.class.getName());

        String headerToken = httpServletRequest.getHeader("Authorize");

        log.info("headerToken--->{}", headerToken);
        if (StringUtils.isNotBlank(headerToken)) {
            SecurityContextHolder.clearContext();
        }

    }
}
