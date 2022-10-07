package com.ruoyi.modules.monitor.config;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

/**
 * 监控权限配置
 *
 * @author ruoyi
 */
@EnableWebSecurity
public class WebSecurityConfigurer {

    /**
     * 权限路径
     */
    private final String adminContextPath;

    /**
     * 通过构造器的方式设置权限路径
     * @param adminServerProperties adminServer配置文件
     */
    public WebSecurityConfigurer(AdminServerProperties adminServerProperties) {
        this.adminContextPath = adminServerProperties.getContextPath();
    }

    /**
     * 配置过滤器链
     * @param httpSecurity  HttpSecurity类似于名称空间配置中的Spring Security的XML
     * @return SecurityFilterChain
     * @throws Exception e
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter("redirectTo");
        successHandler.setDefaultTargetUrl(adminContextPath + "/");

        return httpSecurity
                .headers().frameOptions().disable()
                .and().authorizeRequests()
                .antMatchers(adminContextPath + "/assets/**"
                        , adminContextPath + "/login"
                        , adminContextPath + "/actuator/**"
                        , adminContextPath + "/instances/**"
                ).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage(adminContextPath + "/login")
                .successHandler(successHandler).and()
                .logout().logoutUrl(adminContextPath + "/logout")
                .and()
                .httpBasic().and()
                .csrf()
                .disable()
                .build();
    }


}
