package com.werun.onlinenote_backend.dao;
import com.werun.onlinenote_backend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface CategoryDao extends JpaRepository<Category, String>{
}
