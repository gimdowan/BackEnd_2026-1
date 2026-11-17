package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MemberRepository {

    private final Map<Long, Member> members = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public Member save(Member member) {
        long id = nextId.getAndIncrement();
        member.setId(id);
        members.put(id, member);
        return member;
    }

    public Member findById(Long id) {
        return members.get(id);
    }
}
