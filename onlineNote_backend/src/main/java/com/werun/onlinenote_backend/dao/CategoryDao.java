package com.werun.onlinenote_backend.dao;
import com.werun.onlinenote_backend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName CategoryDao
 * @Description CategoryDao
 * @Author honghaitao
 * @Updater
 * @Create 2022-03-24
 * @Update
 **/
public interface CategoryDao extends JpaRepository<Category, String>{
}
