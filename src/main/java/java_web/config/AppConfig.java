package java_web.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"java_web.dto",
                               "java_web.config",
                               "java_web.repository",
                                "java_web.model",
                                "java_web.service",
                                "java_web.controller"
})
public class AppConfig implements WebMvcConfigurer {

//    // cloudinary
//    private String HOST_NAME = "dyj1ro2lm";
//    private String API_KEY = "947976155119815";
//    private String API_SECRET = "I8ZtO0BoHWbgcdgw7Co4yFZ5lgM";

    // config view
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

//    @Bean
//    public CommonsMultipartResolver multipartResolver() {
//        CommonsMultipartResolver mResolver = new CommonsMultipartResolver();
//        mResolver.setMaxUploadSizePerFile(1024 * 1024 * 10);
//        mResolver.setMaxUploadSize(1024 * 1024 * 30);
//        return mResolver;
//    }

//    @Bean
//    public Cloudinary cloudinary() {
//        return new Cloudinary(ObjectUtils.asMap(
//                "cloud_name", HOST_NAME,
//                "api_key", API_KEY,
//                "api_secret", API_SECRET,
//                "secure", true
//        ));
//    }

}
