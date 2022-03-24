package com.werun.onlinenote_backend.entity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @ClassName Note
 * @Description 笔记
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
    private String title;

    /**
     * 笔记与分类的多对一映射
     */
    @ManyToOne
    @JoinColumn(name="cid")
    private Category category;

    /**
     *创建时间
     */
    @Column
    private Timestamp createTime;

    /**
     * 状态(一开始默认为未完成的'false'状态)
     */
    @Column
    private boolean state = false;


    /**
     * 内容（仅文本）
     */
    @Column
    private String content;
}
