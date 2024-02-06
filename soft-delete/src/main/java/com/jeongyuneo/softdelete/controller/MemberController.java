package com.jeongyuneo.softdelete.controller;

import com.jeongyuneo.softdelete.entity.Member;
import com.jeongyuneo.softdelete.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public Long save(@RequestParam String name) {
        return memberService.save(name);
    }

    @GetMapping
    public List<Member> getMembers() {
        return memberService.getMembers();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        memberService.delete(id);
    }
}
