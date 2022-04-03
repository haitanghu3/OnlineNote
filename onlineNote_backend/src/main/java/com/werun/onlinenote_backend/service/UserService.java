package com.werun.onlinenote_backend.service;

import com.werun.onlinenote_backend.bean.CategoryBean;
import com.werun.onlinenote_backend.bean.UserBean;
import com.werun.onlinenote_backend.dao.UserDao;
import com.werun.onlinenote_backend.entity.Category;
import com.werun.onlinenote_backend.entity.User;
import com.werun.onlinenote_backend.result.UserResult;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserService
 * @Description 实体User的service层
 * @Author liuzijun
 * @Updater
 * @Create 2022-04-03
 * @Update
 **/
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final UserDao userDao;

    public UserResult deleteUser() {
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        if(user == null) {
            return new UserResult(false, "This didn't exist");
        }

        userDao.delete(user);
        return new UserResult(true, "Delete Successfully");
    }

    public UserResult changeUserName(String changeUserName) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        if(user == null) {
            return new UserResult(false, "This didn't exist");
        }

        user.setUserName(changeUserName);
        userDao.save(user);
        List<CategoryBean> categoryBeanList = null;
        for(Category note : user.getCategories()) {
            categoryBeanList.add(new CategoryBean(note));
        }
        return new UserResult(new UserBean(user), categoryBeanList);
    }
}
