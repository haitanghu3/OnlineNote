package com.werun.onlinenote_backend.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName CategoryBean
 * @Description Category类封装
 * @Author liuzijun
 * @Updater
 * @Create 2022-03-26
 * @Update
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryBean {
    private String cid;

    private String categoryName;
}
