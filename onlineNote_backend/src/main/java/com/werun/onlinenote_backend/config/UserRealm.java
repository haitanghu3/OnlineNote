package com.werun.onlinenote_backend.config;

import com.werun.onlinenote_backend.dao.UserDao;
import com.werun.onlinenote_backend.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * @ClassName UserRealm
 * @Description UserRealm
 * @Author honghaitao
 * @Updater liuzijun
 * @Create 2022-03-26
 * @Update 2022-03-31
 **/
public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserDao userDao;

    /**
     * 授权：提供用户信息返回权限信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 认证：提供账户信息返回认证信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //查询当前用户是否存在
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        User user = userDao.findByUserAccount(usernamePasswordToken.getUsername());

        if (user == null) {
            //报错：该用户不存在
            return null;
        }

        //密码认证
        return new SimpleAuthenticationInfo(user, user.getUserPassword(), getName());
    }
}
