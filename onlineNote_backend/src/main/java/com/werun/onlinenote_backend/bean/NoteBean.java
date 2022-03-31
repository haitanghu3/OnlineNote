package com.werun.onlinenote_backend.bean;

import com.werun.onlinenote_backend.entity.Note;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @ClassName NoteBean
 * @Description Note类封装
 * @Author liuzijun
 * @Updater liuzijun
 * @Create 2022-03-26
 * @Update 2022-03-31
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

    public NoteBean(Note note)
    {
        this.nid = note.getNid();
        this.noteTitle = note.getNoteTitle();
        this.noteCreateTime = note.getNoteCreateTime();
        this.noteCompletedState = note.getNoteCompletedState();
        this.noteContent = note.getNoteContent();
    }
}
