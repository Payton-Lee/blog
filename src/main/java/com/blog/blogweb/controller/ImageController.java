package com.blog.blogweb.controller;

import com.blog.blogweb.entity.Image;
import com.blog.blogweb.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ImageController {
    private ImageService imageService;

    @Autowired
    public void setImageService(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/image")
    public List<Image> listImage(@RequestParam String tag) {
        return imageService.getByImageTag(tag);
    }

//    @PostMapping("/image")
//    public Object uploadImage(@RequestParam MultipartFile image) throws IOException {
//        Map<String, Object> map = new HashMap<>();
//
//        Path path = Paths.get("image");
//        if (!Files.exists(path)) {
//            try {
//                Files.createDirectory(path);
//            } catch (IOException e) {
//                throw new IOException("Failed to create directory:" + path, e);
//            }
//        }
//        String fileName = StringUtils.cleanPath(image.getOriginalFilename());
//        map.put("fileName", fileName);
//        Path filePath = path.resolve(fileName);
//        try (InputStream inputStream = image.getInputStream()) {
//            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
//            map.put("isSuccess", true);
//        } catch (IOException e) {
//            throw new IOException("Failed to save image file:" + fileName, e);
//        }
////        map.put("isSuccess",false);
//        return map;
//    }
}
