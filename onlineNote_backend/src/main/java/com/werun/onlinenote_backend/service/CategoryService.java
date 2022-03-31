package com.werun.onlinenote_backend.service;

import com.werun.onlinenote_backend.dao.CategoryDao;
import com.werun.onlinenote_backend.entity.Category;
import com.werun.onlinenote_backend.entity.User;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CategoryService
 * @Description 笔记分类操作相关的service层
 * @Author honghaiao
 * @Updater
 * @Create 2022-03-31
 * @Update
 **/
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryService {

    private final CategoryDao categoryDao;

    public String addCategory(String categoryName){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<Category> categories = user.getCategories();
        for(Category categoryInfo : categories){
            if(categoryInfo.getCategoryName() == categoryName){
                return "you already have this category";
            }
        }
        Category category = new Category();
        category.setCategoryName(categoryName);
        category.setUser(user);
        categoryDao.save(category);
        return "add succeed";
    }

}
