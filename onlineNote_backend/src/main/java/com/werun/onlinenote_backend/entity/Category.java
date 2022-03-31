package com.werun.onlinenote_backend.entity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * @ClassName Category
 * @Description 分类
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
@Table(name = "category")
public class Category {
    /**
     * id，使用uuid
     */
    @Id
    @GeneratedValue(generator = "jpa_uuid")
    @GenericGenerator(name = "jpa_uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String cid;

    /**
     * 分类的名字
     */
    @Column
    private String categoryName;

    /**
     * 分类与笔记的一对多映射
     */
    @OneToMany(mappedBy = "noteCategory",fetch = FetchType.EAGER)
    private List<Note> notes;

    /**
     * 分类与用户的多对一映射
     */
    @ManyToOne
    @JoinColumn(name = "uid")
    private User user;
}
