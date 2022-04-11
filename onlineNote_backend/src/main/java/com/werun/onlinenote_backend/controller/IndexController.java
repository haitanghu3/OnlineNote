package com.werun.onlinenote_backend.controller;

import com.werun.onlinenote_backend.result.IndexResult;
import com.werun.onlinenote_backend.service.IndexService;
import com.werun.onlinenote_backend.util.ConstUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName IndexController
 * @Description 登录、注册操作的控制器
 * @Author honghaitao
 * @Updater
 * @Create 2022-03-31
 * @Update
 **/
@Controller
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class IndexController {

    private final IndexService indexService;


    @ResponseBody
    @PostMapping(ConstUtil.LOGIN)
    public IndexResult login(@RequestParam("userAccount") String userAccount,
                             @RequestParam("userPassword") String userPassword,
                             HttpServletRequest req){

        return indexService.login(userAccount, userPassword,req);
    }

    @ResponseBody
    @PostMapping(ConstUtil.REGISTER)
    public IndexResult register(@RequestParam("userName") String userName,
                           @RequestParam("userAccount") String userAccount,
                        @RequestParam("userPassword") String userPassword){

        return indexService.register(userName,userAccount,userPassword);
    }

    @ResponseBody
    @PostMapping(ConstUtil.LOGOUT)
    public IndexResult logout(){

        return indexService.logout();
    }

}
