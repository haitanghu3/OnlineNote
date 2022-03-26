package com.werun.onlinenote_backend.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @ClassName NoteBean
 * @Description Note类封装
 * @Author liuzijun
 * @Updater
 * @Create 2022-03-26
 * @Update
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteBean {
    private String nid;

    private String noteTitle;

    private Timestamp noteCreateTime;

    private Boolean noteCompletedState;

    private String noteContent;
}
