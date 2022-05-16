package com.fbj.config;

import com.fbj.handler.LoginHandler;
import org.springframework.boot.web.reactive.filter.OrderedHiddenHttpMethodFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("admin/login");

    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandler()).addPathPatterns("/**").excludePathPatterns("admin/login.html", "/login", "/","/tologin","/css/**","/404/**","/images/**","/lib/**","/bloglogin","/bloglayui/**","/article","/read","/read/**","/blogmessage"
      ,"/search","/blogsearch/**","/blogsearch","/article/**","/addcomment" );
    }
}
