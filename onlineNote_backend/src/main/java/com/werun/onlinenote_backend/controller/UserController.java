package com.werun.onlinenote_backend.controller;

import com.werun.onlinenote_backend.result.UserResult;
import com.werun.onlinenote_backend.service.UserService;
import com.werun.onlinenote_backend.util.ConstUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName UserController
 * @Description 实体User的控制器
 * @Author liuzijun
 * @Updater liuzijun
 * @Create 2022-03-31
 * @Update 2022-03-31
 **/
@Controller
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserController {

    private final UserService userService;

    @ResponseBody
    @PostMapping(ConstUtil.DELETE_USER)
    public UserResult deleteUserByUserName(@RequestParam("userName") String userName){
        return userService.deleteUserByUserName(userName);
    }

    @ResponseBody
    @PostMapping(ConstUtil.CHANGE_USER_NAME)
    public UserResult changeUserNameByUserName(@RequestParam("userName") String userName,
                                               @RequestParam("changeUserName") String changeUserName){
        return userService.changeUserNameByUserName(userName, changeUserName);
    }

}
