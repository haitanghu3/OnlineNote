package com.werun.onlinenote_backend.controller;

import com.werun.onlinenote_backend.entity.Category;
import com.werun.onlinenote_backend.result.NoteResult;
import com.werun.onlinenote_backend.service.NoteService;
import com.werun.onlinenote_backend.util.ConstUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;

/**
 * @ClassName NoteController
 * @Description 实体Note的控制器
 * @Author liuzijun
 * @Updater
 * @Create 2022-03-31
 * @Update
 **/
@Controller
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class NoteController {

    private final NoteService noteService;

    @ResponseBody
    @PostMapping(ConstUtil.ADD_NOTE)
    public NoteResult addNoteByNoteName(@RequestParam("noteTitle") String noteTitle,
                                        @RequestParam("noteCategory") Category noteCategory,
                                        @RequestParam("noteCompletedState") Boolean noteCompletedState,
                                        @RequestParam("noteCreateTime") Timestamp noteCreateTime,
                                        @RequestParam("noteContent") String noteContent) {
        return noteService.addNoteByNoteTitle(noteTitle, noteCategory, noteCompletedState, noteCreateTime, noteContent);
    }

//    @ResponseBody
//    @PostMapping(ConstUtil.DELETE_NOTE)
//    public NoteResult deleteNoteByNoteName(@RequestParam("noteTitle") String noteTitle) {
//        return noteService.deleteNoteByNoteName(noteTitle);
//    }
//
//    @ResponseBody
//    @PostMapping(ConstUtil.GET_NOTE)
//    public NoteResult getNoteByNoteName(@RequestParam("noteTitle") String noteTitle) {
//        return noteService.getNoteByNoteName(noteTitle);
//    }
//
//    @ResponseBody
//    @PostMapping(ConstUtil.CHANGE_NOTE_CONTENT)
//    public NoteResult changeNoteContentByNoteName(@RequestParam("noteTitle") String noteTitle,
//                                               @RequestParam("changeNoteContent") String changeNoteContent) {
//        return noteService.changeNoteContentByNoteName(noteTitle, changeNoteContent);
//    }

}
