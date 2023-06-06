package com.example.spring.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new ConcurrentHashMap<>();
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }
    @Override
    public Optional<Member> findById(Long memberId) {
        return Optional.ofNullable(store.get(memberId));
    }
}
