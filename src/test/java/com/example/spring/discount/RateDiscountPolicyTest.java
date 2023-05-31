package com.example.spring.discount;

import com.example.spring.member.Grade;
import com.example.spring.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();
    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vipYes(){
        //Given
        Member memberVIP = new Member(1L, "memberVIP", Grade.VIP);
        //When
        int discount = discountPolicy.discount(memberVIP, 10000);
        //Then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("BASIC은 10% 할인이 적용되면 안된다.")
    void vipNot(){
        //Given
        Member memberVIP = new Member(2L, "memberBASIC", Grade.BASIC);
        //When
        int discount = discountPolicy.discount(memberVIP, 10000);
        //Then
        assertThat(discount).isEqualTo(0);
    }
}