package com.fbj.config;

import com.fbj.pojo.User;
import com.fbj.service.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
@Autowired
UserServiceImpl userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        Subject subject= SecurityUtils.getSubject();
        User crrentUser=(User)subject.getPrincipal();
        System.out.println(crrentUser.getPerms());
        simpleAuthorizationInfo.addStringPermission(crrentUser.getPerms());
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user=userService.findByUsername(token.getUsername());
        if(user==null){
           return  null;
        }
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    //密码认证，shiro自动帮助我们验证了
    }
}
