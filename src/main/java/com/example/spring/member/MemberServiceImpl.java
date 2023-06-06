package com.example.spring.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    @Autowired //ac.getBean(MemberRepository.class) 자동을 생성하는 어노테이션
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        Optional.ofNullable(member).orElseThrow(NullPointerException::new);
        memberRepository.save(member);
    }
    @Override
    public Optional<Member> findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
