package com.fbj.config;


import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
@Bean  //第三步·
public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager")DefaultWebSecurityManager defaultWebSecurityManager){
   ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
   shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
    Map<String,String>  map = new LinkedHashMap<>();
    map.put("admin/index","perms[user:add]");
    map.put("admin/index","authc");
shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

return   shiroFilterFactoryBean;
}


@Bean  //第二步
public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
    DefaultWebSecurityManager  securityManager=new DefaultWebSecurityManager();
securityManager.setRealm(userRealm);
 return  securityManager;
}


@Bean  //1.第一步
public UserRealm userRealm(){
    return new UserRealm();
}


@Bean  //用来整合shiro 与 thynmeleaf
public ShiroDialect getShiroDialect(){
    return  new ShiroDialect();
}
}
