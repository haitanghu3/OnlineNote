package com.werun.onlinenote_backend.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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
    private String account;

    /**
     * 用户token
     */
    @Column String token;

}
