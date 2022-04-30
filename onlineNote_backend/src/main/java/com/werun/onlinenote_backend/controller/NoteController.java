package com.werun.onlinenote_backend.controller;

import com.werun.onlinenote_backend.entity.Category;
import com.werun.onlinenote_backend.result.AllNoteResult;
import com.werun.onlinenote_backend.result.NoteResult;
import com.werun.onlinenote_backend.service.NoteService;
import com.werun.onlinenote_backend.util.ConstUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
                              @RequestParam("noteContent") String noteContent,
                              @RequestParam("noteCompletedState") Boolean noteCompletedState,
                              @RequestParam("description") String description
                              ) {
        return noteService.addNote(noteTitle, cid, noteContent,noteCompletedState,description);
    }

    @ResponseBody
    @DeleteMapping(ConstUtil.DELETE_NOTE)
    public NoteResult deleteNote(@RequestParam("nid") String nid) {
        return noteService.deleteNote(nid);
    }

    @ResponseBody
    @GetMapping(ConstUtil.GET_NOTE)
    public NoteResult getNote(@RequestParam("nid") String nid) {
        return noteService.getNote(nid);
    }

    @ResponseBody
    @PutMapping(ConstUtil.CHANGE_NOTE_TITLE)
    public NoteResult changeNoteTitle(@RequestParam("nid") String nid,
                                        @RequestParam("changeNoteTitle") String changeNoteTitle) {
        return noteService.changeNoteTitle(nid, changeNoteTitle);
    }

    @ResponseBody
    @PutMapping(ConstUtil.CHANGE_NOTE_CATEGORY)
    public NoteResult changeNoteCategory(@RequestParam("nid") String nid,
                                        @RequestParam("cid") String cid) {
        return noteService.changeNoteCategory(nid, cid);
    }

    @ResponseBody
    @PutMapping(ConstUtil.CHANGE_NOTE_COMPLETED_STATE)
    public NoteResult changeNoteCompletedState(@RequestParam("nid") String nid,
                                        @RequestParam("changeNoteCompletedState") Boolean changeNoteCompletedState) {
        return noteService.changeNoteCompletedState(nid, changeNoteCompletedState);
    }

    @ResponseBody
    @PutMapping(ConstUtil.CHANGE_NOTE_CONTENT)
    public NoteResult changeNoteContent(@RequestParam("nid") String nid,
                                               @RequestParam("changeNoteContent") String changeNoteContent) {
        return noteService.changeNoteContent(nid, changeNoteContent);
    }

    @ResponseBody
    @GetMapping(ConstUtil.GET_ALL_NOTE)
    public AllNoteResult getAllNote(){
        return noteService.getAllNote();
    }

    @ResponseBody
    @GetMapping(ConstUtil.GET_NOTE_BY_NOTETITLE)
    public AllNoteResult getNoteByNoteTitle(@RequestParam("noteTitle") String noteTitle){
        return noteService.getNoteByNoteTitle(noteTitle);
    }

    @ResponseBody
    @PostMapping(ConstUtil.CHANGE_NOTE_ALL)
    public NoteResult changeNoteAll(@RequestParam("nid") String nid,
                                    @RequestParam("changeNoteTitle") String changeNoteTitle,
                                    @RequestParam("cid") String cid,
                                    @RequestParam("changeNoteContent") String changeNoteContent){

        return noteService.changeNoteAll(nid,changeNoteTitle,cid,changeNoteContent);
    }
}
