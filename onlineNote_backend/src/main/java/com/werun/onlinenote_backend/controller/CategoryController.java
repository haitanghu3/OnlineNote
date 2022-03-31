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
 * @Update 2022-03-31
 **/
@Controller
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CategoryController {

    private final CategoryService categoryService;

    @ResponseBody
    @PostMapping(ConstUtil.ADD_CATEGORY)
    public CategoryResult addCategoryByCategoryName(@RequestParam("categoryName") String categoryName){
        return categoryService.addCategoryByCategoryName(categoryName);
    }

    @ResponseBody
    @PostMapping(ConstUtil.DELETE_CATEGORY)
    public CategoryResult deleteCategoryByCategoryName(@RequestParam("categoryName") String categoryName){
        return categoryService.deleteCategoryByCategoryName(categoryName);
    }

    @ResponseBody
    @PostMapping(ConstUtil.GET_CATEGORY)
    public CategoryResult getCategoryByCategoryName(@RequestParam("categoryName") String categoryName){
        return categoryService.getCategoryByCategoryName(categoryName);
    }

    @ResponseBody
    @PostMapping(ConstUtil.CHANGE_CATEGORY_NAME)
    public CategoryResult changeCategoryNameByCategoryName(@RequestParam("categoryName") String categoryName,
                                             @RequestParam("changeCategoryName") String changeCategoryName){
        return categoryService.changeCategoryNameByCategoryName(categoryName, changeCategoryName);
    }
}
