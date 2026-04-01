package com.example.springstart.repository;

import com.example.springstart.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository {
    static Long sequence = 0L;
    private final Map<Long, Member> store = new HashMap<>();

    public Member save(Member member) {
        member.setId(sequence);
        store.put(sequence, member);
        sequence++;
        return member;
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    public Member findByName(String name) {
        for (Member m : store.values()) {
            if (m.getName().equals(name)) {
                return m;
            }
        }
        return null;
    }

}
