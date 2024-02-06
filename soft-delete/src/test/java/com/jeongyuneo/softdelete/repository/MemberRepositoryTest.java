package com.jeongyuneo.softdelete.repository;

import com.jeongyuneo.softdelete.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    void 멤버를_생성한다() {
        Member member = Member.builder()
                .name("jeongyuneo")
                .build();
        memberRepository.save(member);
    }

    @Test
    void 멤버를_삭제하면_조회되지_않는다() {
        // given
        Member member = Member.builder()
                .name("jeongyuneo")
                .build();
        memberRepository.save(member);
        // when
        memberRepository.deleteById(member.getId());
        // then
        assertThat(memberRepository.findAll()).isEmpty();
    }
}
