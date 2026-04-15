package com.example.springstart.repository;

import com.example.springstart.domain.Member;

import java.util.List;

public interface MemberRepository {
    Member save(Member member);
    Member findByName(String name);
    List<Member> findAll();
    List<Member> findAllByOrderByIdDesc();
}
