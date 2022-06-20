package com.guoxi.springdevice.config;

import com.guoxi.springdevice.filter.JwtLoginFilter;
import com.guoxi.springdevice.filter.JwtTokenFilter;
import com.guoxi.springdevice.handler.*;
import com.guoxi.springdevice.provider.JwtAuthenticationProvider;
import com.guoxi.springdevice.service.UserLoginServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author guoxi@tg-hd.com
 * @since 2022/6/10$
 */
@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 数据库查询用户服务
     */
    private final UserLoginServiceImpl userService;
    /**
     * 密码
     */
    private final PasswordEncoder passwordEncoder;
    /**
     * 登录成功
     */
    private final AuthSuccessHandler authSuccessHandler;
    /**
     * 登录失败
     */
    private final AuthFailureHandler authFailureHandler;
    /**
     * 注销
     */
    private final CustomizeLogoutHandler customizeLogoutHandler;

    /**
     * 注销成功
     */
    private final AccountLogoutSuccessHandler accountLogoutSuccessHandler;
    /**
     * 未登录访问
     */
    private final AuthEntryPoint authEntryPoint;
    /**
     * 权限不足
     */
    private final CustomizeAccessDeniedHandler customizeAccessDeniedHandler;

    /**
     * 权限控制
     */
//    private final FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource;

    /**
     * 配置认证方式
     *
     * @param auth 认证处理器
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }

    /**
     * 放行静态资源
     *
     * @param web 参数
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/swagger-ui.html", "/swagger-resources/**", "/webjars/**", "/v2/**", "/api/**");
        web.ignoring().antMatchers("/private/api/register/**");
    }

    /**
     * 如下代码中我们对/api/user/**路径设置了角色权限，
     * 只有拥有 USER 角色的用户才能够正常访问，
     * 而/api/admin/**路径只允许 ADMIN 角色访问。
     * /register 和/register/下的所有路径允许所有用户访问，而除此之外的路径至少先通过认证才能访问。
     *
     * @param http 配置参数
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 自定义登陆拦截器
        JwtLoginFilter jwtLoginFilter = new JwtLoginFilter();
        jwtLoginFilter.setAuthenticationManager(authenticationManagerBean());
        jwtLoginFilter.setAuthenticationSuccessHandler(authSuccessHandler);
        jwtLoginFilter.setAuthenticationFailureHandler(authFailureHandler);

        JwtTokenFilter jwtTokenFilter = new JwtTokenFilter();

        // 使用自定义验证实现器
        JwtAuthenticationProvider jwtAuthenticationProvider = new JwtAuthenticationProvider(userService, passwordEncoder);

        // 登陆验证信息
        http.authenticationProvider(jwtAuthenticationProvider)
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login");

        // jwt 拦截器配置
        http.sessionManagement()
                //禁用session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable()
                // 添加拦截器
                .addFilterAt(jwtLoginFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterAfter(jwtTokenFilter, JwtLoginFilter.class);

        // 权限处理信息
        http.exceptionHandling()
                //   用来解决认证过的用户访问无权限资源时的异常
                .accessDeniedHandler(customizeAccessDeniedHandler)
                // 用来解决匿名用户访问无权限资源时的异常
                .authenticationEntryPoint(authEntryPoint)
                .and().logout().addLogoutHandler(customizeLogoutHandler).permitAll().logoutSuccessHandler(accountLogoutSuccessHandler);
    }
}
