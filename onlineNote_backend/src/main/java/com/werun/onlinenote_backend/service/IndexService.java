package com.werun.onlinenote_backend.service;

import com.werun.onlinenote_backend.dao.UserDao;
import com.werun.onlinenote_backend.entity.User;
import com.werun.onlinenote_backend.result.IndexResult;
import com.werun.onlinenote_backend.util.JwtUtils;
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

import javax.servlet.http.HttpServletRequest;
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

    /*public IndexResult login(String userAccount, String userPassword, Model model) {
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();

        ByteSource salt = ByteSource.Util.bytes(userAccount);
        String newPassword = new SimpleHash("MD5", userPassword, salt, 1024).toHex();
        //封装当前用户数据
        UsernamePasswordToken userToken = new UsernamePasswordToken(userAccount, newPassword);


        try {
            subject.login(userToken);//执行登录方法

            User user = (User) subject.getPrincipal();

        } catch (UnknownAccountException e) {//用户名不存在
            model.addAttribute("msg", "用户名错误");
            return new IndexResult("用户不存在", false);
        } catch (IncorrectCredentialsException e) {//密码不存在
            model.addAttribute("msg", "密码错误");
            return new IndexResult("密码错误", false);
        }
        //以上貌似最好封装到util层?(我现在就先写在这里吧)
        return new IndexResult("登录成功", true, userToken);
    }*/
    public IndexResult login(String userAccount, String userPassword, HttpServletRequest req){
        //尝试登录
        ByteSource salt = ByteSource.Util.bytes(userAccount);
        String newPassword = new SimpleHash("MD5", userPassword, salt, 1024).toHex();
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(userAccount, newPassword));
        } catch (UnknownAccountException e) {//用户名不存在
            return new IndexResult("用户不存在", false);
        } catch (IncorrectCredentialsException e) {//密码不存在
            return new IndexResult("密码错误", false);
        }
        User user = (User) subject.getPrincipal();
        String id = user.getUid();
        //生成jwtToken
        String jwtToken = JwtUtils.createToken(id,user.getUserAccount(), subject.getSession().getId().toString());
        //设置好token，后来会在全局处理的时候放入响应里
        req.setAttribute("token", jwtToken);
        return new IndexResult("登录成功", true,jwtToken);
    }
    public IndexResult register(String userName, String userAccount,String userPassword){
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
            return new IndexResult("注册成功",true);
        }
        return new IndexResult("该用户已注册",false);

    }

    public IndexResult logout(){
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()) {
            subject.logout();
        }

        return new IndexResult("登出成功",true);
    }
}
