package com.werun.onlinenote_backend.controller;

import com.werun.onlinenote_backend.service.IndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class IndexController {

    private final IndexService indexService;


    @ResponseBody
    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model){
        indexService.login(username, password,model);
        return "login";
    }
}
