package com.example.spring.discount;

import com.example.spring.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
