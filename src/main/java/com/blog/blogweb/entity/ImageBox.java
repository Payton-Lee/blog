package com.blog.blogweb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("b_share_img_box")
public class ImageBox {
    private Integer id;
    private String title;
    private String introduce;
    private String image;
}
