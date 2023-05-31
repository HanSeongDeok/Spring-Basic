package com.example.spring.member;

import java.util.Optional;

public interface MemberService {
    void join(Member member);
    Optional<Member> findMember(Long memberId);
}
