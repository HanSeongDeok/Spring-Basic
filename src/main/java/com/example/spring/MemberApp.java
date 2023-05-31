package com.example.spring;

import com.example.spring.member.Grade;
import com.example.spring.member.Member;
import com.example.spring.member.MemberService;
import com.example.spring.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.AnnotationConfigurationException;

public class MemberApp {
    public static void main(String[] args) {
       /* AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();*/

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member memberA = new Member(1L, "MemberA", Grade.VIP);
        memberService.join(memberA);

        Member findMember = memberService.findMember(1L).get();
        System.out.println(memberA.getName());
        System.out.println(findMember.getName());
    }
}
