//package com.fbj.config;
//
//import com.fbj.handler.LoginHandler;
//import org.springframework.boot.web.reactive.filter.OrderedHiddenHttpMethodFilter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.LocaleResolver;
//import org.springframework.web.servlet.config.annotation.*;
//
//@Configuration
//public class MvcConfig extends WebMvcConfigurationSupport {
//
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("admin/login");
//
//    }
//
//
//   @Override
//   public void addInterceptors(InterceptorRegistry registry) {
//       registry.addInterceptor(new LoginHandler()).addPathPatterns("/**").excludePathPatterns("admin/login.html", "/login", "/","/tologin","/css/**","/404/**","/images/**","/lib/**","/bloglogin","/bloglayui/**","/article","/read","/read/**","/blogmessage"
//     ,"/search","/blogsearch/**","/blogsearch","/article/**","/articles/**","/listlink","/bloglink" ,"/**/*.css", "/**/*.js","/bianyi");
//   }
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")//配置允许跨域的路径
//                .allowedOrigins("*")//配置允许访问的跨域资源的请求域名
//                .allowedMethods("PUT,POST,GET,DELETE,OPTIONS")//配置允许访问该跨域资源服务器的请求方法，如：POST、GET、PUT、DELETE等
//                .allowedHeaders("*"); //配置允许请求header的访问，如 ：X-TOKEN
//        super.addCorsMappings(registry);
//    }
//}
