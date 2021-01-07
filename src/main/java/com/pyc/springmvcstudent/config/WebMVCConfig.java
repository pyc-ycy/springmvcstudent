//IntelliJ IDEA
//springmvcstudent
//WebMVCConfig
//2021/1/7
// Author:御承扬
//E-mail:2923616405@qq.com

package com.pyc.springmvcstudent.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("Index");
    }
}
