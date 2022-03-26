package com.werun.onlinenote_backend.dao;
import com.werun.onlinenote_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @ClassName UserDao
 * @Description UserDao
 * @Author honghaitao
 * @Updater liuzijun
 * @Create 2022-03-24
 * @Update 2022-03-26
 **/
public interface UserDao extends JpaRepository<User, String> {
    User findByUserAccount(String userAccount);
}
