package com.werun.onlinenote_backend.controller;

import com.werun.onlinenote_backend.service.CategoryService;
import com.werun.onlinenote_backend.util.ConstUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName CategoryController
 * @Description 笔记分类操作的控制器
 * @Author honghaitao
 * @Updater
 * @Create 2022-03-31
 * @Update
 **/
@Controller
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CategoryController {

    private final CategoryService categoryService;

    @ResponseBody
    @PostMapping(ConstUtil.ADD_CATEGORY)
    public String addCategory(@RequestParam("categoryName") String categoryName){
        return categoryService.addCategory(categoryName);
    }
}
