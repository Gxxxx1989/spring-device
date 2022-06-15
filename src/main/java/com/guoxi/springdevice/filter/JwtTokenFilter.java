package com.guoxi.springdevice.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guoxi.springdevice.constant.ReturnStatus;
import com.guoxi.springdevice.mybatis.entity.UserEntity;
import com.guoxi.springdevice.token.JwtLoginToken;
import com.guoxi.springdevice.utils.JwtUtils;
import com.guoxi.springdevice.utils.ReturnJsonUtil;
import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Token有效性验证拦截器
 *
 * @author guoxi@tg-hd.com
 * @since 2022/6/15 16:14
 */
public class JwtTokenFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String token = httpServletRequest.getHeader("Authentication");
        if (StringUtils.isEmpty(token)) {
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            ReturnJsonUtil<String> jsonResult = new ReturnJsonUtil<>();
            jsonResult.setStatus(ReturnStatus.USER_NOT_LOGIN);
            jsonResult.setStatusCode(ReturnStatus.USER_NOT_LOGIN.getStatusCode());
            jsonResult.setStatusMsg(ReturnStatus.USER_NOT_LOGIN.getStatusMsg());
            httpServletResponse.getWriter().write(objectMapper.writeValueAsString(jsonResult));
            return;
        }

        Claims claims = JwtUtils.parseJWT(token);
        if (JwtUtils.isTokenExpired(claims)) {
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            ReturnJsonUtil<String> jsonResult = new ReturnJsonUtil<>();
            jsonResult.setStatus(ReturnStatus.USER_LOGIN_FIELD);
            jsonResult.setStatusCode(ReturnStatus.USER_LOGIN_FIELD.getStatusCode());
            jsonResult.setStatusMsg(ReturnStatus.USER_LOGIN_FIELD.getStatusMsg());
            httpServletResponse.getWriter().write(new ObjectMapper().writeValueAsString(jsonResult));
            return;
        }
        UserEntity user = objectMapper.readValue(claims.get("userDetails", String.class), UserEntity.class);
        JwtLoginToken jwtLoginToken = new JwtLoginToken(user, "", user.getAuthorities());
        jwtLoginToken.setDetails(new WebAuthenticationDetails(httpServletRequest));
        SecurityContextHolder.getContext().setAuthentication(jwtLoginToken);
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }


}
