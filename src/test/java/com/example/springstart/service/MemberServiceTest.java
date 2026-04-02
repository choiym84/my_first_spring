package com.example.springstart.service;

import com.example.springstart.domain.Member;
import com.example.springstart.repository.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService service = new MemberService(new MemoryMemberRepository());

    @Test
    void join_success() {

        //given "choi"를 가입시킨다.
        Member member = new Member(1L, "choi");
        service.join(member);

        //when 멤버의 총 수는 몇일까?
        List<Member> members = service.findMembers();

        //then 1이 나와야 한다.
        assertEquals(1, members.size());

    }

    @Test
    void join_duplicateName_throwsException() {

        //given "choi"란 이름으로 이미 존재한다면.
        Member member1 = new Member(1L, "choi");
        service.join(member1);

        //when "choi"란 이름으로 다시 등록을 시도한다면.
        Member member2 = new Member(2L, "choi");

        //then 비즈니스 로직에 따라 예외를 터뜨려야 한다.
        assertThrows(IllegalStateException.class, () ->
            service.join(member2)
        );
    }

    @Test
    void findMembers() {

        //given : kim, choi, park 세명을 등록한 상태
        Member member1 = new Member(1L, "kim");
//        Member member2 = new Member(2L, "choi");
//        Member member3 = new Member(3L, "park");

        service.join(member1);
//        service.join(member2);
//        service.join(member3);

        //when : 모든 멤버를 가져오는 findMembers()를 했을 때 잘 가져오는 지 확인하자.
        List<Member> members = service.findMembers();

        //then 하나씩 순서대로 뽑았을 때 앞에서 넣은 객체와 같다면 그것을 그대로 넣은 것이라고 할 수 있다.
        assertEquals(1,members.size());
        assertTrue(members.contains(member1));
//        assertTrue(members.contains(member3));
//        assertTrue(members.contains(member2));
        assertTrue(members.get(0).getName().equals("kim"));
    }
}