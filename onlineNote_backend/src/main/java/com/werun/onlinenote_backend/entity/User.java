package com.werun.onlinenote_backend.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * @ClassName User
 * @Description 用户
 * @Author honghaitao
 * @Updater
 * @Create 2022-03-24
 * @Update
 **/
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    /**
     *  id，使用uuid
     */
    @Id
    @GeneratedValue(generator = "jpa_uuid")
    @GenericGenerator(name = "jpa_uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String uid;

    /**
     * 用户姓名
     */
    @Column
    private String name;

    /**
     * 用户账号
     */
    @Column
    private String userName;

    /**
     * 用户密码
     */
    @Column
    private String password;

    /**
     *用户与分类的一对多映射
     */
    @OneToMany(mappedBy = "user")
    private List<Category> categories;
}
