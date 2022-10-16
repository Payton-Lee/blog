package com.blog.blogweb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.blogweb.entity.User;

public interface UserService extends IService<User> {
    public User getByUserName(String username);
    public String getToken(User user);
    public String getEncryptedPassword(String password);
    public Boolean verifyPassword(String password, String pw_hash);
    public Boolean register(User user);
}
