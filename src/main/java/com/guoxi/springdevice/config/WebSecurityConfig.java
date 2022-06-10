package com.guoxi.springdevice.config;

import com.guoxi.springdevice.handler.AccountLogoutSuccessHandler;
import com.guoxi.springdevice.handler.AuthEntryPoint;
import com.guoxi.springdevice.handler.AuthFailureHandler;
import com.guoxi.springdevice.handler.AuthSuccessHandler;
import com.guoxi.springdevice.service.UserLoginServiceImpl;
import com.guoxi.springdevice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author guoxi@tg-hd.com
 * @since 2022/6/10$
 */
@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserLoginServiceImpl userService;
    private final PasswordEncoder passwordEncoder;

    private final AuthSuccessHandler authSuccessHandler;
    private final AuthFailureHandler authFailureHandler;
    private final AccountLogoutSuccessHandler accountLogoutSuccessHandler;
    private final AuthEntryPoint authEntryPoint;

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
        web.ignoring().antMatchers("/**/*.css", "/**/*.js", "/img/**", "/admin/images/**"
        );
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
        http.authorizeRequests()
                .antMatchers("/swagger-ui.html", "/swagger-resources/**", "/webjars/**", "/v2/**", "/api/**").permitAll()
                .antMatchers("/register", "/register/**").permitAll()
                .antMatchers("/**").authenticated()
                .and()
                .formLogin()
                // 设置登录接口路径，登录方式为 post 请求，字段为用户名 username 及密码 password
                .loginProcessingUrl("/login")
                .successHandler(authSuccessHandler)
                .failureHandler(authFailureHandler)
                .and()
                .logout()
                .logoutSuccessHandler(accountLogoutSuccessHandler)
                .deleteCookies("JSESSIONID")
                .and()
                .exceptionHandling()  // 异常处理
                .authenticationEntryPoint(authEntryPoint)
                .and().csrf().disable();
    }
}
