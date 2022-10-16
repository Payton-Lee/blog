package com.blog.blogweb.controller;

import com.blog.blogweb.entity.Image;
import com.blog.blogweb.entity.result.ResultData;
import com.blog.blogweb.entity.enums.ReturnCode;
import com.blog.blogweb.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping("/image")
public class ImageController {
    private ImageService imageService;

    @Autowired
    public void setImageService(ImageService imageService) {
        this.imageService = imageService;
    }
    @GetMapping("/image")
    public Object uploadImage(HttpServletRequest request, @RequestParam MultipartFile file) throws IOException {
        Path path = Paths.get("image");
        if (!Files.exists(path)) {
            try {
                Files.createDirectory(path);
            } catch (IOException e) {
                throw new IOException("Failed to create directory:" + path, e);
            }
        }
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path filePath = path.resolve(fileName);
        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            return ResultData.success(ReturnCode.RC201.code, ReturnCode.RC201.message, fileName);
        } catch (IOException e) {
            throw new IOException("Failed to save image file:" + fileName, e);
        }
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
