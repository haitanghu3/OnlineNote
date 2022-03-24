package com.werun.onlinenote_backend.dao;
import com.werun.onlinenote_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, String> {

}
