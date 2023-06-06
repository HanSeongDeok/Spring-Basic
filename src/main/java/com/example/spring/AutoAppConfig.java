package com.example.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        /**
         * Default basePackages 는 @ComponentScan 가 붙은 클래스의 패키지
        */
        basePackages = "com.example.spring",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
                classes = Configuration.class)
)
public class AutoAppConfig {

}
