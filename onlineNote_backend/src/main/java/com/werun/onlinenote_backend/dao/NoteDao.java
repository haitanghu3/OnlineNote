package com.werun.onlinenote_backend.dao;
import com.werun.onlinenote_backend.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
/**
 * @ClassName NoteDao
 * @Description NoteDao
 * @Author honghaitao
 * @Updater
 * @Create 2022-03-24
 * @Update
 **/
public interface NoteDao extends JpaRepository<Note, String>{
}
