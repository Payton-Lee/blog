package com.blog.blogweb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.blogweb.entity.ImageBox;
import com.blog.blogweb.mapper.ImageBoxMapper;
import com.blog.blogweb.service.ImageBoxService;
import org.springframework.stereotype.Service;

@Service
public class ImageBoxServiceImpl extends ServiceImpl<ImageBoxMapper, ImageBox> implements ImageBoxService {
}
