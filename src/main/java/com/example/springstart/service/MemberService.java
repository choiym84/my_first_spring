package com.example.springstart.service;

import com.example.springstart.domain.Member;
import com.example.springstart.repository.JpaMemberRepository;
import com.example.springstart.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class MemberService {

    private final JpaMemberRepository jpaMemberRepository;

    public MemberService(JpaMemberRepository jpaMemberRepository) {
        this.jpaMemberRepository = jpaMemberRepository;
    }

    public Member join(Member member) {
        Member foundMember = jpaMemberRepository.findByName(member.getName());
        if (member.getName() == null || member.getName().isBlank()) {
            throw new IllegalArgumentException("이름은 비어 있을 수 없습니다.");
        }
        if (foundMember != null) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
        return jpaMemberRepository.save(member);
    }

    public List<Member> findMembers() {
        return this.jpaMemberRepository.findAll();
    }
}
