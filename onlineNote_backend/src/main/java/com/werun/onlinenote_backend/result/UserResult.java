package com.werun.onlinenote_backend.result;

import com.werun.onlinenote_backend.bean.CategoryBean;
import com.werun.onlinenote_backend.bean.NoteBean;
import com.werun.onlinenote_backend.bean.UserBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName UserResult
 * @Description User类结果封装
 * @Author liuzijun
 * @Updater liuzijun
 * @Create 2022-03-26
 * @Update 2022-03-31
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResult {
    private UserBean userBean;

    private List<CategoryBean> categoryBeanList;

    private Boolean isSuccess;

    private String status;

    public UserResult(UserBean userBean, List<CategoryBean> categoryBeanList)
    {
        this.userBean = userBean;
        this.categoryBeanList = categoryBeanList;
        this.isSuccess = true;
        this.status = "Successful";
    }

    public UserResult(Boolean isSuccess, String status)
    {
        this.isSuccess = isSuccess;
        this.status = status;
    }
}
