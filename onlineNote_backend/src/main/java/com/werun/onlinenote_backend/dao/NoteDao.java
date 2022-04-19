package com.werun.onlinenote_backend.dao;
import com.werun.onlinenote_backend.entity.Category;
import com.werun.onlinenote_backend.entity.Note;
import com.werun.onlinenote_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @ClassName NoteDao
 * @Description NoteDao
 * @Author honghaitao
 * @Updater
 * @Create 2022-03-24
 * @Update
 **/
public interface NoteDao extends JpaRepository<Note, String> {
    Note findNoteByNidAndUid(String nid, String uid);
    List<Note> findByUid(String uid);
    List<Note> findByNoteCategory(Category category);
    List<Note> findByNoteTitleAndUid(String noteTitle,String Uid);
}
