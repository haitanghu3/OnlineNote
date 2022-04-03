package com.werun.onlinenote_backend.result;

import com.werun.onlinenote_backend.bean.CategoryBean;
import com.werun.onlinenote_backend.bean.NoteBean;
import com.werun.onlinenote_backend.bean.UserBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName NoteResult
 * @Description Note类结果封装
 * @Author liuzijun
 * @Updater
 * @Create 2022-03-26
 * @Update
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteResult {
    private NoteBean noteBean;

    private CategoryBean categoryBean;

    private Boolean success;

    private String msg;

    public NoteResult(NoteBean noteBean, CategoryBean categoryBean)
    {
        this.noteBean = noteBean;
        this.categoryBean = categoryBean;
        this.success = true;
        this.msg = "success";
    }

    public NoteResult(Boolean success, String msg)
    {
        this.success = success;
        this.msg = msg;
    }
}
