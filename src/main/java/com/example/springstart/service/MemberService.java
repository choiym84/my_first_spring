package com.example.springstart.service;

import com.example.springstart.domain.Member;
import com.example.springstart.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemoryMemberRepository memoryMemberRepository;

    public MemberService(MemoryMemberRepository memoryMemberRepository) {
        this.memoryMemberRepository = memoryMemberRepository;
    }

    public Member join(Member member) {
        Member foundMember = memoryMemberRepository.findByName(member.getName());
        if (foundMember != null) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
        return memoryMemberRepository.save(member);
    }

    public List<Member> findMembers() {
        return this.memoryMemberRepository.findAll();
    }
}
