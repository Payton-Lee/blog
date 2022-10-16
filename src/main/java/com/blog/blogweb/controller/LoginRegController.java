package com.blog.blogweb.controller;

import cn.hutool.core.lang.Dict;
import com.blog.blogweb.entity.User;
import com.blog.blogweb.entity.enums.ReturnCode;
import com.blog.blogweb.entity.result.ResultData;
import com.blog.blogweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginRegController {
    private UserService userService;

    @Autowired
    protected void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public Object login(@RequestBody User user) {
        Dict result = Dict.create();
        User userInDB = userService.getByUserName(user.getUsername());
        if (userService.verifyPassword(user.getPassword(), userInDB.getPassword())){
            String token = userService.getToken(user);
            result.set("username", userInDB.getUsername()).set("msg", "登录成功").set("token", token);
            return ResultData.success(ReturnCode.RC200.code, ReturnCode.RC200.message, result);
        } else {
            return ResultData.fail(ReturnCode.PASSWORD_ERROR.code, ReturnCode.PASSWORD_ERROR.message);
        }

    }
}
