package com.blog.blogweb.controller;

import cn.hutool.core.lang.Dict;
import com.blog.blogweb.entity.ImageBox;
import com.blog.blogweb.entity.enums.ReturnCode;
import com.blog.blogweb.entity.result.ResultData;
import com.blog.blogweb.service.ImageBoxService;
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
@RequestMapping("/imagebox")
public class ImageBoxController {
    private ImageBoxService imageBoxService;

    @Autowired
    private void setImageBoxService(ImageBoxService imageBoxService) {
        this.imageBoxService = imageBoxService;
    }
    @PostMapping("/image")
    public Object uploadImage(HttpServletRequest request, @RequestParam MultipartFile file) throws IOException {
        Path path = Paths.get("imageBox");
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

    @PostMapping("/saveimage")
    public Object saveImage(@RequestParam ImageBox imageBox) {
        Dict data = Dict.create();
        boolean res = imageBoxService.save(imageBox);
        if(res) {
            data.set("title", imageBox.getTitle()).set("introduce", imageBox.getIntroduce()).set("image", imageBox.getImage());
            return ResultData.success(ReturnCode.RC200.code, ReturnCode.RC200.message, data);
        }
        return ResultData.fail(ReturnCode.RC999.code, ReturnCode.RC999.message);
    }
}
