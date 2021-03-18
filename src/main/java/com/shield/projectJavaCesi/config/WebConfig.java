//package com.shield.projectJavaCesi.config;



//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Configuration
//@ComponentScan
//public class WebConfig extends WebMvcConfigurerAdapter {
//
////    @Override
////    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////        registry.addResourceHandler("/**").addResourceLocations("/index.html");
////    }
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/shield/").setViewName("forward:/index.html");
//    }
//}
//

//import org.springframework.context.annotation.Bean;
//        import org.springframework.context.annotation.Configuration;
//        import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Configuration
//public class WebConfig {
//
//    @Bean
//    public WebMvcConfigurer forwardToIndex() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
//                // forward requests to /admin and /user to their index.html
//                registry.addViewController("/index").setViewName(
//                        "forward:/index.html");
//                registry.addViewController("/user").setViewName(
//                        "forward:/user/index.html");
//            }
//        };
//    }
//
//}