package com.blog.blogweb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.blogweb.entity.Image;

import java.util.List;

public interface ImageService extends IService<Image> {
    List<Image> getByImageTag(String tag);
}
