package com.guoxi.springdevice.filter;

import com.guoxi.springdevice.token.JwtLoginToken;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 验证用户名密码正确后，生成一个token，并将token返回给客户端
 * 该类继承自UsernamePasswordAuthenticationFilter，重写了其中的2个方法 ,
 * attemptAuthentication：接收并解析用户凭证。
 * successfulAuthentication：用户成功登录后，这个方法会被调用，我们在这个方法里生成token并返回。
 *
 * @author  guoxi@tg-hd.com
 * @since 2022/6/15 15:38
 *
 */
@RequiredArgsConstructor
public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    /**
     * security拦截默认是以POST形式走/login请求，我们这边设置为走/token请求
     *
     * @param authenticationManager
     */
    public JwtLoginFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        super.setFilterProcessesUrl("/token");
    }

    /**
     * 接收并解析用户凭证
     *
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        //创建未认证的凭证(etAuthenticated(false)),注意此时凭证中的主体principal为用户名
        JwtLoginToken jwtLoginToken = new JwtLoginToken(userName, password);
        //将认证详情(ip,sessionId)写到凭证
        jwtLoginToken.setDetails(new WebAuthenticationDetails(request));
        //AuthenticationManager获取受支持的AuthenticationProvider(这里也就是JwtAuthenticationProvider),
        //生成已认证的凭证,此时凭证中的主体为userDetails  --- 这里会委托给AuthenticationProvider实现类来验证
        // 即 跳转到 JwtAuthenticationProvider.authenticate 方法中认证
        Authentication authenticatedToken = this.getAuthenticationManager().authenticate(jwtLoginToken);
        return authenticatedToken;

    }
    /**
     * 成功验证后调用的方法
     * 如果验证成功，就生成token并返回
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);

    }

    /**
     * 失败 返回错误就行
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.getWriter().write("authentication failed, reason: " + failed.getMessage());
    }
}
