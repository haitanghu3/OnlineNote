package com.werun.onlinenote_backend.config;

import com.werun.onlinenote_backend.util.ConstUtil;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName ShiroConfig
 * @Description ShiroConfig
 * @Author honghaitao
 * @Updater liuzijun
 * @Create 2022-03-26
 * @Update 2022-03-31
 **/
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager defaultWebSecurityManager){

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //添加Shiro的内置过滤器
            /*
                anon: 无需认证
                authc: 必须认证
            */
        LinkedHashMap<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put(ConstUtil.LOGIN, "anon"); //对登录界面不拦截
        filterMap.put(ConstUtil.REGISTER, "anon"); //对注册界面不拦截
        filterMap.put(ConstUtil.OTHERS, "authc"); //拦截其他页面
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        shiroFilterFactoryBean.setLoginUrl(ConstUtil.LOGIN); //拦截后跳转到登录页面
        return shiroFilterFactoryBean;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){

        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();

        //关联UserRealm
        defaultWebSecurityManager.setRealm(userRealm);
        return defaultWebSecurityManager;
    }

    //创建realm对象
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

}