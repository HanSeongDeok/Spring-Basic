package com.example.spring;

import com.example.spring.member.Grade;
import com.example.spring.member.Member;
import com.example.spring.member.MemberService;
import com.example.spring.member.MemberServiceImpl;
import com.example.spring.order.Order;
import com.example.spring.order.OrderService;
import com.example.spring.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class orderApp {
    public static void main(String[] args) {
        /*AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();*/

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);
        System.out.println("order: " + order);
        System.out.println("order.calculatePrice: " + order.calculatePrice());
    }
}
