package com.example.spring.beanfind;

import com.example.spring.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.AnnotationConfigurationException;

import java.util.Arrays;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames)
                .forEach(o -> System.out.println("name = " + o + "object = " + ac.getBean(o)));
    }
    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames)
                .filter(s -> ac.getBeanDefinition(s).getRole()== BeanDefinition.ROLE_APPLICATION)
                .forEach(s -> System.out.println("name = " + s + "object = " + ac.getBean(s)));
    }
    @Test
    @DisplayName("스프링이 내부에서 사용하는 빈 출력하기")
    void findInfraStructureBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames)
                .filter(s -> ac.getBeanDefinition(s).getRole()== BeanDefinition.ROLE_INFRASTRUCTURE)
                .forEach(s -> System.out.println("name = " + s + "object = " + ac.getBean(s)));
    }
}
