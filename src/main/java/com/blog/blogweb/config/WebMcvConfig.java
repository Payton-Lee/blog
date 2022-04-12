package com.blog.blogweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class WebMcvConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Path path = Paths.get("image");
        String absolutePath = path.toFile().getAbsolutePath();
        System.out.println(absolutePath);
        registry.addResourceHandler("/image/**").addResourceLocations("file:/" + absolutePath + "/");
    }
}
