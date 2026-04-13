package com.example.springstart.service;

import com.example.springstart.domain.Member;
import com.example.springstart.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Member join(Member member) {
        if (member.getName() == null || member.getName().isBlank()) {
            throw new IllegalArgumentException("이름은 비어 있을 수 없습니다.");
        }
        Member foundMember = memberRepository.findByName(member.getName());
        if (foundMember != null) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
        return memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public List<Member> findMembers() {
        return this.memberRepository.findAll();
    }
}
