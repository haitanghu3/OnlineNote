package com.werun.onlinenote_backend.bean;

import com.werun.onlinenote_backend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName UserBean
 * @Description User类封装
 * @Author liuzijun
 * @Updater liuzijun
 * @Create 2022-03-26
 * @Update 2022-03-31
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBean {
    private String uid;

    private String userName;

    private String userAccount;

    public UserBean(User user)
    {
        this.uid = user.getUid();
        this.userName = user.getUserName();
        this.userAccount = user.getUserAccount();
    }

}
