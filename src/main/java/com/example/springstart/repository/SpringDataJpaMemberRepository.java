package com.example.springstart.repository;

import com.example.springstart.domain.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Primary
public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>, MemberRepository {
    Member findByName(String name);
    List<Member> findAllByOrderByIdDesc();
}
