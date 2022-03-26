package com.werun.onlinenote_backend.result;

import com.werun.onlinenote_backend.bean.CategoryBean;
import com.werun.onlinenote_backend.bean.NoteBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
