package com.example.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String tmpDir = System.getProperty("java.io.tmpdir"); // 예: /tmp
        registry.addResourceHandler("/files/**")
                .addResourceLocations("file:" + tmpDir + "/");
    }
}
