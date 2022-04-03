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
    public NoteResult addNote(@RequestParam("noteTitle") String noteTitle,
                                        @RequestParam("cid") String cid,
                                        @RequestParam("noteCompletedState") Boolean noteCompletedState,
                                        @RequestParam("noteCreateTime") Timestamp noteCreateTime,
                                        @RequestParam("noteContent") String noteContent) {
        return noteService.addNote(noteTitle, cid, noteCompletedState, noteCreateTime, noteContent);
    }

    @ResponseBody
    @PostMapping(ConstUtil.DELETE_NOTE)
    public NoteResult deleteNote(@RequestParam("nid") String nid) {
        return noteService.deleteNote(nid);
    }

    @ResponseBody
    @PostMapping(ConstUtil.GET_NOTE)
    public NoteResult getNote(@RequestParam("nid") String nid) {
        return noteService.getNote(nid);
    }

    @ResponseBody
    @PostMapping(ConstUtil.CHANGE_NOTE_TITLE)
    public NoteResult changeNoteTitle(@RequestParam("nid") String nid,
                                        @RequestParam("changeNoteTitle") String changeNoteTitle) {
        return noteService.changeNoteTitle(nid, changeNoteTitle);
    }

    @ResponseBody
    @PostMapping(ConstUtil.CHANGE_NOTE_CATEGORY)
    public NoteResult changeNoteCategory(@RequestParam("nid") String nid,
                                        @RequestParam("cid") String cid) {
        return noteService.changeNoteCategory(nid, cid);
    }

    @ResponseBody
    @PostMapping(ConstUtil.CHANGE_NOTE_COMPLETED_STATE)
    public NoteResult changeNoteCompletedState(@RequestParam("nid") String nid,
                                        @RequestParam("changeNoteCompletedState") Boolean changeNoteCompletedState) {
        return noteService.changeNoteCompletedState(nid, changeNoteCompletedState);
    }

    @ResponseBody
    @PostMapping(ConstUtil.CHANGE_NOTE_CONTENT)
    public NoteResult changeNoteContent(@RequestParam("nid") String nid,
                                               @RequestParam("changeNoteContent") String changeNoteContent) {
        return noteService.changeNoteContent(nid, changeNoteContent);
    }

}
