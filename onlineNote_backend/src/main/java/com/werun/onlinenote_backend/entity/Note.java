package com.werun.onlinenote_backend.entity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @ClassName Note
 * @Description 笔记
 * @Author honghaitao
 * @Updater liuzijun
 * @Create 2022-03-24
 * @Update 2022-03-26
 **/
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "note")
public class Note {

    /**
     *  id，使用uuid
     */
    @Id
    @GeneratedValue(generator = "jpa_uuid")
    @GenericGenerator(name = "jpa_uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String nid;

    /**
     * 笔记标题
     */
    @Column
    private String noteTitle;

    /**
     * 笔记与分类的多对一映射
     */
    @ManyToOne
    @JoinColumn(name = "cid")
    private Category noteCategory;

    /**
     *创建时间
     */
    @Column
    private Timestamp noteCreateTime;

    /**
     * 状态(一开始默认为未完成的'false'状态)
     */
    @Column
    private Boolean noteCompletedState = false;

    /**
     * 内容（仅文本）
     */
    @Column
    private String noteContent;

    /**
     * 用户id
     */
    @Column
    private String uid;
}
