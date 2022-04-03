package com.werun.onlinenote_backend.service;

import com.werun.onlinenote_backend.dao.UserDao;
import com.werun.onlinenote_backend.entity.User;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.UUID;

/**
 * @ClassName IndexService
 * @Description 登录认证、用户注册相关的service层
 * @Author honghaiao
 * @Updater
 * @Create 2022-03-26
 * @Update 2022-03-31
 **/
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class IndexService {

    private final UserDao userDao;

    public String login(String userAccount, String userPassword, Model model){
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();

        ByteSource salt = ByteSource.Util.bytes(userAccount);
        String newPassword = new SimpleHash("MD5", userPassword, salt,1024).toHex();
        //封装当前用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(userAccount, newPassword);

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

    public String register(String userName, String userAccount,String userPassword){
        ByteSource salt = ByteSource.Util.bytes(userAccount);
        String newPassword = new SimpleHash("MD5", userPassword, salt,1024).toHex();

        User user = new User();
        user.setUserName(userName);
        user.setUserAccount(userAccount);
        user.setUserPassword(newPassword);

        //看数据库中是否存在该用户
        User userInfo = userDao.findByUserAccount(userAccount);
        if(userInfo == null){
            userDao.save(user);
            return "register succeed";
        }
        return "register failed";

    }

    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()) {
            subject.logout();
        }

        return "logout";
    }
}
