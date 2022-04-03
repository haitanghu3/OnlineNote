package com.werun.onlinenote_backend.controller;

import com.werun.onlinenote_backend.result.CategoryResult;
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
 * @Description 实体Category的控制器
 * @Author honghaitao
 * @Updater liuzijun
 * @Create 2022-03-31
 * @Update 2022-04-03
 **/
@Controller
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CategoryController {

    private final CategoryService categoryService;

    @ResponseBody
    @PostMapping(ConstUtil.ADD_CATEGORY)
    public CategoryResult addCategory(@RequestParam("categoryName") String categoryName){
        return categoryService.addCategory(categoryName);
    }

    @ResponseBody
    @PostMapping(ConstUtil.DELETE_CATEGORY)
    public CategoryResult deleteCategory(@RequestParam("cid") String cid){
        return categoryService.deleteCategory(cid);
    }

    @ResponseBody
    @PostMapping(ConstUtil.GET_CATEGORY)
    public CategoryResult getCategory(@RequestParam("cid") String cid){
        return categoryService.getCategory(cid);
    }

    @ResponseBody
    @PostMapping(ConstUtil.CHANGE_CATEGORY_NAME)
    public CategoryResult changeCategoryName(@RequestParam("cid") String cid,
                                             @RequestParam("changeCategoryName") String changeCategoryName){
        return categoryService.changeCategoryName(cid, changeCategoryName);
    }
}
