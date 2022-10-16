package com.blog.blogweb;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.blog.blogweb.entity.Image;
import com.blog.blogweb.entity.User;
import com.blog.blogweb.mapper.ImageMapper;
import com.blog.blogweb.service.UserService;
import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BlogApplicationTests {
    @Autowired
    private ImageMapper imageMapper;

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    void getPassword() {
        System.out.println(userService.getEncryptedPassword("12345678"));
    }

    @Test
    void registerNewUser() {
//        User user = new User();
//        user.setId(1);
//        user.setUsername("peytonlee");
//        user.setPassword("12345678");
//        System.out.println(userService.register(user));
    }

    @Test
    void databaseConfig() {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword("peytonlee");

        String userName = textEncryptor.encrypt("root");
        String passWord = textEncryptor.encrypt("12345678");
        String url = textEncryptor.encrypt("jdbc:mysql://localhost:3306/blog?serverTimezone=UTC");
//        System.out.println(userName);
//        System.out.println(passWord);
        System.out.println(url);
    }
}
