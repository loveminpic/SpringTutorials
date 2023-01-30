package hello.hellospring.service;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService = new MemberService();
    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("spring");
        //when
        Long savedId = memberService.join(member);

        //then
        Member result = memberService.findOne(savedId).get();
        assertThat(member.getName()).isEqualTo(result.getName());
    }

    @Test
    public void 중복회원예외(){
        Member member = new Member();
        member.setName("spring");
        memberService.join(member);

        Member member1 = new Member();
        member1.setName("spring");
         memberService.join(member1);

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}