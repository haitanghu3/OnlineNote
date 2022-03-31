package com.werun.onlinenote_backend.result;

import com.werun.onlinenote_backend.bean.CategoryBean;
import com.werun.onlinenote_backend.bean.NoteBean;
import com.werun.onlinenote_backend.bean.UserBean;
import lombok.*;

import java.util.List;

/**
 * @ClassName CategoryResult
 * @Description Category类结果封装
 * @Author liuzijun
 * @Updater liuzijun
 * @Create 2022-03-26
 * @Update 2022-03-31
 **/
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResult {
    private CategoryBean categoryBean;

    private UserBean userBean;

    private List<NoteBean> noteBeanList;

    private Boolean isSuccess;

    private String status;

    public CategoryResult(CategoryBean categoryBean, UserBean userBean, List<NoteBean> noteBeanList)
    {
        this.categoryBean = categoryBean;
        this.userBean = userBean;
        this.noteBeanList = noteBeanList;
        this.isSuccess = true;
        this.status = "Successful";
    }

    public CategoryResult(Boolean isSuccess, String status)
    {
        this.isSuccess = isSuccess;
        this.status = status;
    }

}
