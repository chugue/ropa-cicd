package com.example.finalproject._core.config;


import com.example.finalproject._core.interceptor.AppInterceptor;
import com.example.finalproject._core.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/api/**")
                .excludePathPatterns();
        registry.addInterceptor(new AppInterceptor())
                .addPathPatterns("/app/**")
                .excludePathPatterns();

    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);

        registry
                // 파일 다운로드 URL 패턴
                .addResourceHandler("/upload/**")
                // 실제 파일이 저장된 경로
                .addResourceLocations("file:./upload/")
                .setCachePeriod(60 * 60) // 초 단위 => 한시간
                .resourceChain(true)
                .addResolver(new PathResourceResolver());

        registry.addResourceHandler("/images/**")
                .addResourceLocations("classpath:/images/")
                .setCachePeriod(60 * 60)
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }
}