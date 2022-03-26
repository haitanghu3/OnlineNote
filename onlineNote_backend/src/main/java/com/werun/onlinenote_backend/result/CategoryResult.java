package com.werun.onlinenote_backend.result;

import com.werun.onlinenote_backend.bean.CategoryBean;
import com.werun.onlinenote_backend.bean.NoteBean;
import com.werun.onlinenote_backend.bean.UserBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName CategoryResult
 * @Description Category类结果封装
 * @Author liuzijun
 * @Updater
 * @Create 2022-03-26
 * @Update
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResult {
    private CategoryBean categoryBean;

    private UserBean userBean;

    private List<NoteBean> noteBeanList;
}
