package com.werun.onlinenote_backend.config;

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
 * @Updater
 * @Create 2022-03-26
 * @Update
 **/
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        //添加Shiro的内置过滤器
            /*
                anon: 无需认证
                authc: 必须认证
            */
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/login","anon"); //对登录界面不拦截
        filterMap.put("/register","anon"); //对注册界面不拦截
        filterMap.put("/**","authc"); //拦截其他页面

        bean.setFilterChainDefinitionMap(filterMap);

        bean.setLoginUrl("/login"); //拦截后跳转到登录页面

        return bean;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    //关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //创建realm对象
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }
}
