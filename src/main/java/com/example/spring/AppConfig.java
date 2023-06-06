package com.example.spring;

import com.example.spring.discount.DiscountPolicy;
import com.example.spring.discount.FixDiscountPolicy;
import com.example.spring.discount.RateDiscountPolicy;
import com.example.spring.member.MemberRepository;
import com.example.spring.member.MemberService;
import com.example.spring.member.MemberServiceImpl;
import com.example.spring.member.MemoryMemberRepository;
import com.example.spring.order.OrderService;
import com.example.spring.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(getMemberRepository());
    }
    /**
     * Order 에 사용될 저장소와 할인 정책 설정
     * @return
     */
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(getMemberRepository(), rateDiscountPolicy());
    }

    @Bean
    public MemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }
    /**
     * 고정 할인 정책
     * @return
     */
    @Bean
    public DiscountPolicy fixDiscountPolicy() {
        return new FixDiscountPolicy();
    }
    /**
     * 비율 할인 정책
     * @return
     */
    @Bean
    public DiscountPolicy rateDiscountPolicy() {
        return new RateDiscountPolicy();
    }
}
