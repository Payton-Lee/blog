package com.blog.blogweb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("b_back_user")
public class User {
    private Integer id;
    private String username;
    private String password;
}
