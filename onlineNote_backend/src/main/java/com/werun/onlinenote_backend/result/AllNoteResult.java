package com.werun.onlinenote_backend.result;

import com.werun.onlinenote_backend.bean.CategoryBean;
import com.werun.onlinenote_backend.bean.NoteBean;
import com.werun.onlinenote_backend.bean.UserBean;
import lombok.*;

import java.util.List;

/**
 * @ClassName AllNoteResult
<<<<<<< HEAD
 * @Description 要返回多个note结果时的封装
=======
 * @Description AllNote类结果封装
>>>>>>> f8499b0a30217c1509860f75e7887153d8a647ed
 * @Author honghaitao
 * @Updater
 * @Create 2022-04-16
 * @Update
 **/
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllNoteResult {
    private List<NoteBean> noteBeanList;

    private Boolean success;

    private String msg;

    public AllNoteResult(List<NoteBean> noteBeanList)
    {
        this.noteBeanList = noteBeanList;
        this.success = true;
        this.msg = "success";
    }

    public AllNoteResult(Boolean success, String msg)
    {
        this.success = success;
        this.msg = msg;
    }
}
