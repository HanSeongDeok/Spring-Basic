package com.example.spring.member;

import java.util.Optional;

public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

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
}
