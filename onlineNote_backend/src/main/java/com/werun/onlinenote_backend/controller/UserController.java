package com.werun.onlinenote_backend.controller;

import com.werun.onlinenote_backend.result.UserResult;
import com.werun.onlinenote_backend.service.UserService;
import com.werun.onlinenote_backend.util.ConstUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UserController
 * @Description 实体User的控制器
 * @Author liuzijun
 * @Updater liuzijun
 * @Create 2022-03-31
 * @Update 2022-04-03
 **/
@Controller
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserController {

    private final UserService userService;

    @ResponseBody
    @DeleteMapping(ConstUtil.DELETE_USER)
    public UserResult deleteUser() {
        return userService.deleteUser();
    }

    @ResponseBody
    @GetMapping(ConstUtil.GET_USER)
    public UserResult getUser() {
        return userService.getUser();
    }

    @ResponseBody
    @PutMapping(ConstUtil.CHANGE_USER_NAME)
    public UserResult changeUserName(@RequestParam("changeUserName") String changeUserName) {
        return userService.changeUserName(changeUserName);
    }

}
