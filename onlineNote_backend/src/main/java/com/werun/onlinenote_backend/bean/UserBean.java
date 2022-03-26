package com.werun.onlinenote_backend.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName UserBean
 * @Description User类封装
 * @Author liuzijun
 * @Updater
 * @Create 2022-03-26
 * @Update
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBean {
    private String uid;

    private String userName;

    private String userAccount;

}
