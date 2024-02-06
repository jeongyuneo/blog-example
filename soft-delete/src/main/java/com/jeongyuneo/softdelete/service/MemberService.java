package com.jeongyuneo.softdelete.service;

import com.jeongyuneo.softdelete.entity.Member;
import com.jeongyuneo.softdelete.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public Long save(String name) {
        Member member = Member.builder()
                .name(name)
                .build();
        memberRepository.save(member);
        return member.getId();
    }

    @Transactional(readOnly = true)
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    public void delete(Long id) {
        memberRepository.deleteById(id);
    }
}
