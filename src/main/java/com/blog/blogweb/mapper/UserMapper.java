package com.blog.blogweb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.blogweb.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
