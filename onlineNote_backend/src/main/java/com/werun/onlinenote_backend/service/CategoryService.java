package com.werun.onlinenote_backend.service;

import com.werun.onlinenote_backend.bean.NoteBean;
import com.werun.onlinenote_backend.bean.UserBean;
import com.werun.onlinenote_backend.dao.CategoryDao;
import com.werun.onlinenote_backend.entity.Category;
import com.werun.onlinenote_backend.entity.Note;
import com.werun.onlinenote_backend.entity.User;
import com.werun.onlinenote_backend.result.CategoryResult;
import com.werun.onlinenote_backend.bean.CategoryBean;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CategoryService
 * @Description 实体Category的service层
 * @Author honghaitao
 * @Updater liuzijun
 * @Create 2022-03-31
 * @Update 2022-04-03
 **/
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryService {

    private final CategoryDao categoryDao;

    public CategoryResult addCategory(String categoryName) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        Category category = categoryDao.findCategoryByCategoryNameAndUser(categoryName, user);

        if(category != null) {
            return new CategoryResult(false, "This existed");
        }

        category.setCategoryName(categoryName);
        category.setUser(user);
        categoryDao.save(category);
        List<NoteBean> noteBeanList = null;
        for(Note note : category.getNotes()) {
            noteBeanList.add(new NoteBean(note));
        }
        return new CategoryResult(new CategoryBean(category), new UserBean(user), noteBeanList);
    }

    public CategoryResult deleteCategory(String cid) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        Category category = categoryDao.findCategoryByCidAndUser(cid, user);

        if(category == null) {
            return new CategoryResult(false, "This didn't exist");

        }

        categoryDao.delete(category);
        return new CategoryResult(true, "Delete Successfully");
    }

    public CategoryResult getCategory(String cid) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        Category category = categoryDao.findCategoryByCidAndUser(cid, user);

        if(category == null) {
            return new CategoryResult(false, "This didn't exist");
        }

        List<NoteBean> noteBeanList = null;
        for(Note note : category.getNotes()) {
            noteBeanList.add(new NoteBean(note));
        }
        return new CategoryResult(new CategoryBean(category), new UserBean(user), noteBeanList);
    }

    public CategoryResult changeCategoryName(String cid, String changeCategoryName) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Category category = categoryDao.findCategoryByCidAndUser(cid, user);

        if(category == null) {
            return new CategoryResult(false, "This existed");
        }

        category.setCategoryName(changeCategoryName);
        categoryDao.save(category);
        List<NoteBean> noteBeanList = null;
        for(Note note : category.getNotes()) {
            noteBeanList.add(new NoteBean(note));
        }
        return new CategoryResult(new CategoryBean(category), new UserBean(user), noteBeanList);
    }

}
