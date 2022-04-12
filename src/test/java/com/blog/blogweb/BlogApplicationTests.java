package com.blog.blogweb;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.blog.blogweb.entity.Image;
import com.blog.blogweb.mapper.ImageMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BlogApplicationTests {
    @Autowired
    private ImageMapper imageMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void selectListMapper() {
        List<Image> list = imageMapper.selectList(Wrappers.<Image>lambdaQuery().like(Image::getTag, "个人"));
        list.forEach(System.out::println);
    }

}
