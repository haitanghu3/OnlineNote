package com.werun.onlinenote_backend.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/**
 * @ClassName IndexService
 * @Description 登录认证相关的service层
 * @Author honghaiao
 * @Updater
 * @Create 2022-03-26
 * @Update
 **/
@Service
public class IndexService {
    public String login(String username, String password, Model model){
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装当前用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try{
            subject.login(token);//执行登录方法
        }catch (UnknownAccountException e){//用户名不存在
            model.addAttribute("msg","用户名错误");
            return "login failed.";
        }catch (IncorrectCredentialsException e){//密码不存在
            model.addAttribute("msg","密码错误");
            return "login failed.";
        }
        //以上貌似最好封装到util层?(我现在就先写在这里吧)
        return "login";
    }

}
