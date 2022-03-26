package com.werun.onlinenote_backend.dao;
import com.werun.onlinenote_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @ClassName UserDao
 * @Description UserDao
 * @Author honghaitao
 * @Updater
 * @Create 2022-03-24
 * @Update
 **/
public interface UserDao extends JpaRepository<User, String> {
    User findByUserName(String userName);
}
