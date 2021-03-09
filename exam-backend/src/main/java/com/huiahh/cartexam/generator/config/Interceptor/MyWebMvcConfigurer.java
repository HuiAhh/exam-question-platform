package com.huiahh.cartexam.generator.config.Interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**添加要拦截的路径
        registry.addInterceptor(new AuthorityInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("html")
                .excludePathPatterns("css")
                .excludePathPatterns("images");
         */
    }

}
