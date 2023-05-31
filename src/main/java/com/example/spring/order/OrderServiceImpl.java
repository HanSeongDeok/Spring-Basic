package com.example.spring.order;

import com.example.spring.discount.DiscountPolicy;
import com.example.spring.discount.FixDiscountPolicy;
import com.example.spring.discount.RateDiscountPolicy;
import com.example.spring.member.Member;
import com.example.spring.member.MemberRepository;
import com.example.spring.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId).get();
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
