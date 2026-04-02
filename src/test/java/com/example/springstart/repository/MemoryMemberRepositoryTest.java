package com.example.springstart.repository;

import com.example.springstart.domain.Member;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {
        MemoryMemberRepository repository = new MemoryMemberRepository();

        @Test
        void save() {
            Member member = new Member();
            member.setName("kim");

            repository.save(member);

            List<Member> result = repository.findAll();

            assertEquals(1, result.size());
            assertEquals("kim", result.get(0).getName());
            assertNotNull(result.get(0).getId());
        }

        @Test
        void findByName() {
            Member member1 = new Member();
            member1.setName("kim");
            repository.save(member1);

            Member member2 = new Member();
            member2.setName("lee");
            repository.save(member2);

            Member result = repository.findByName("lee");

            assertNotNull(result);
            assertEquals("lee", result.getName());
        }

        @Test
        void findAll() {
            Member member1 = new Member();
            member1.setName("kim");
            repository.save(member1);

            Member member2 = new Member();
            member2.setName("lee");
            repository.save(member2);

            List<Member> result = repository.findAll();

            assertEquals(2, result.size());
        }

}


