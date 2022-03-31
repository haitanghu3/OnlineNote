package com.werun.onlinenote_backend.service;

import com.werun.onlinenote_backend.bean.CategoryBean;
import com.werun.onlinenote_backend.bean.NoteBean;
import com.werun.onlinenote_backend.dao.CategoryDao;
import com.werun.onlinenote_backend.dao.NoteDao;
import com.werun.onlinenote_backend.entity.Category;
import com.werun.onlinenote_backend.entity.Note;
import com.werun.onlinenote_backend.entity.User;
import com.werun.onlinenote_backend.result.NoteResult;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * @ClassName NoteService
 * @Description 实体Note的service层
 * @Author liuzijun
 * @Updater
 * @Create 2022-03-31
 * @Update
 **/
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class NoteService {

    private final NoteDao noteDao;
    private final CategoryDao categoryDao;

    public NoteResult addNoteByNoteTitle(String noteTitle, Category noteCategory, Boolean noteCompletedState, Timestamp noteCreateTime, String noteContent) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        Category category = categoryDao.findCategoryByCategoryNameAndUser(noteCategory.getCategoryName(), user);

        Note note = noteDao.findNoteByNoteTitleAndNoteCategory(noteTitle, category);

        if(note != null) {
            return new NoteResult(false, "This existed");
        }

        note.setNoteTitle(noteTitle);
        note.setNoteCategory(noteCategory);
        note.setNoteCompletedState(noteCompletedState);
        note.setNoteCreateTime(noteCreateTime);
        note.setNoteContent(noteContent);

        noteDao.save(note);
        return new NoteResult(new NoteBean(note), new CategoryBean(noteCategory));
    }

//    public NoteResult deleteNoteByNoteTitle(String noteTitle) {
//        User user = (User) SecurityUtils.getSubject().getPrincipal();
//
//        Category category = categoryDao.findCategoryByCategoryNameAndUser(noteCategory.getCategoryName(), user);
//
//        Note note = noteDao.findNoteByNoteTitleAndNoteCategory(noteTitle, category);
//
//        if(note == null) {
//            return new NoteResult(false, "This didn't exist");
//
//        }
//
//        noteDao.delete(note);
//        return new NoteResult(true, "Delete Successfully");
//    }
//
//    public NoteResult getNoteByNoteTitle(String noteTitle) {
//        User user = (User) SecurityUtils.getSubject().getPrincipal();
//
//        Note note = noteDao.findNoteByNoteTitle(noteTitle);
//
//        if(note == null) {
//            return new NoteResult(false, "This didn't exist");
//        }
//
//        List<NoteBean> noteBeanList = null;
//        for(Note note : note.getNotes()) {
//            noteBeanList.add(new NoteBean(note));
//        }
//        return new NoteResult(new NoteBean(note), new UserBean(user), noteBeanList);
//    }
//
//    public NoteResult changeNoteContentByNoteTitle(String noteTitle, String changeNoteContent) {
//        User user = (User) SecurityUtils.getSubject().getPrincipal();
//
//        Note note = noteDao.findNoteByNoteTitle(noteTitle);
//
//        if(note == null) {
//            return new NoteResult(false, "This existed");
//        }
//
//        note.setNoteName(changeNoteName);
//        noteDao.save(note);
//        List<NoteBean> noteBeanList = null;
//        for(Note note : note.getNotes()) {
//            noteBeanList.add(new NoteBean(note));
//        }
//        return new NoteResult(new NoteBean(note), new UserBean(user), noteBeanList);
//    }
}
