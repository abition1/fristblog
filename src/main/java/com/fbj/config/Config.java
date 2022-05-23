package com.fbj.config;
import com.fbj.handler.LoginHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
// 跨域访问
public class Config implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("admin/login");

    }

    @Override
   public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(new LoginHandler()).addPathPatterns("/**").excludePathPatterns("admin/login.html", "/login", "/","/tologin","/css/**","/404/**","/images/**","/lib/**","/bloglogin","/bloglayui/**","/article","/read","/read/**","/blogmessage"
     ,"/search","/blogsearch/**","/blogsearch","/article/**","/articles/**","/listlink","/bloglink" ,"/**/*.css", "/**/*.js","/bianyi","/api/code/run");
   }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 添加映射路径



        registry.addMapping("/**")
                // 放行哪些原始域
                // .allwedOrigins("*")  // 2.2 之前的版本用的
                .allowedOriginPatterns("*")
                // 是否发送 Cookie 信息
                .allowCredentials(true)
                // 放行哪些原始域（请求方式）
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                // 放行哪些头部信息
                .allowedHeaders("*")
                // 暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
                .exposedHeaders("Header1", "Header2");
    }

}

