package com.werun.onlinenote_backend.dao;
import com.werun.onlinenote_backend.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface NoteDao extends JpaRepository<Note, String>{
}
