package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        //given
        Member member = new Member("jyjin",36);

        //when
        Member savedMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(member);
    }

    @Test
    void findAll(){
        //given
        Member member1 = new Member("jyjin",36);
        Member member2 = new Member("shchoi",36);

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> all = memberRepository.findAll();

        //then
        assertThat(all.size()).isEqualTo(2);
        assertThat(all).contains(member1, member2);
    }
}