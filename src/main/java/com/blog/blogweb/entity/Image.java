package com.blog.blogweb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("b_share_img")
public class Image {
    @TableId
    private Integer id;
    private String title;
    private String introduce;
    private String image;
}