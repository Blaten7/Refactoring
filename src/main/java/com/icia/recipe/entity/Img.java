package com.icia.recipe.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "img")
public class Img implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "i_num")
    private Long img_num;

    @Column(name = "i_path", nullable = false, length = 500)
    private String img_path;

    @Column(name = "i_sys_name", nullable = false, length = 250)
    private String img_sys_name;

    @Column(name = "i_original_name", nullable = false, length = 250)
    private String img_origin_name;

    @Column(name = "f_num", columnDefinition = "VARCHAR(50) DEFAULT NULL")
    private String f_num;

    @Column(name = "i_filesize", nullable = false, length = 20)
    private String img_filesize;

    @Column(name = "i_register_name", nullable = false, length = 30, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private Date img_register_name;

    @ManyToMany
    @JoinTable(name = "recipe_img",
    joinColumns = @JoinColumn(name = "img_r_num"),
    inverseJoinColumns = @JoinColumn(name = "recipe_r_num"))
    private List<Recipe> recipe_img_list = new ArrayList<Recipe>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "m_id", insertable = false, updatable = false)
    private Member who_upload_img;


}
