package com.werun.onlinenote_backend.controller;

import com.werun.onlinenote_backend.service.IndexService;
import com.werun.onlinenote_backend.util.ConstUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String login(@RequestParam("userAccount") String userAccount,
                        @RequestParam("userPassword") String userPassword,
                        Model model){
        String message = indexService.login(userAccount, userPassword,model);
        return message;
    }

    @ResponseBody
    @PostMapping(ConstUtil.REGISTER)
    public String register(@RequestParam("userName") String userName,
                           @RequestParam("userAccount") String userAccount,
                        @RequestParam("userPassword") String userPassword){
        String message = indexService.register(userName,userAccount,userPassword);
        return message;
    }

    @ResponseBody
    @PostMapping(ConstUtil.LOGOUT)
    public String logout(){
        String message = indexService.logout();
        return message;
    }

}
