package com.werun.onlinenote_backend.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * @ClassName User
 * @Description 用户
 * @Author honghaitao
 * @Updater liuzijun
 * @Create 2022-03-24
 * @Update 2022-03-31
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
     * 用户昵称
     */
    @Column
    private String userName;

    /**
     * 用户账号
     */
    @Column
    private String userAccount;

    /**
     * 用户密码
     */
    @Column
    private String userPassword;

    /**
     *用户与分类的一对多映射
     */
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<Category> categories;

}
