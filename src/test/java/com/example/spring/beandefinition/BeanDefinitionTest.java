package com.example.spring.beandefinition;

import com.example.spring.AppConfig;
import com.example.spring.xml.XmlAppContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlReaderContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.support.GenericXmlContextLoader;

import java.util.Arrays;

public class BeanDefinitionTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    GenericXmlApplicationContext xc = new GenericXmlApplicationContext("appConfig.xml");
    @Test
    @DisplayName("XML 빈 설정 메타 정보 확인")
    void findXmlApplicationBean(){
        String [] beanDefinitionNames = xc.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames)
                .filter(name -> {
                    BeanDefinition beanDefinition = xc.getBeanDefinition(name);
                    return beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION;
                }).forEach(name -> {
                    System.out.println("beanDefinitionName = " + name +
                            "beanDefinition = " + xc.getBeanDefinition(name));
                });
    }

    @Test
    @DisplayName("빈 설정 메타 정보 확인")
    void findApplicationBean(){
        String [] beanDefinitionNames = ac.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames)
                .filter(name -> {
                    BeanDefinition beanDefinition = ac.getBeanDefinition(name);
                    return beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION;
                }).forEach(name -> {
                    System.out.println("beanDefinitionName = " + name +
                            "beanDefinition = " + ac.getBeanDefinition(name));
                });
    }
}
