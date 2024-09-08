package com.yami.shop.common.config;

import com.yami.shop.common.util.FilePathUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    private final Logger logger = LoggerFactory.getLogger(WebMvcConfigurer.class);

    //项目路径
    private static String uploadDir = FilePathUtil.filePath();

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //springboot 直接访问静态资源(界面)
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        //场景：部署的Springboot项目，打成jar包，需要通过url直接访问jar外部路径的资源(相当于直接访问Linux文件夹的数据)
        //http://121.4.242.133:7004/image/home.jpg(意思是说我只要访问image，就会去获取/home/java/file的文件)
        //addResourceHandler是指你想在url请求的路径
        //addResourceLocations是图片存放的真实路径
        //registry.addResourceHandler("/image/**").addResourceLocations("file:///home/java/");

        registry.addResourceHandler("/file/**").addResourceLocations("file:///" + uploadDir);
        super.addResourceHandlers(registry);
    }
}
