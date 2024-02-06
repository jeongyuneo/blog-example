package com.jeongyuneo.softdelete.repository;

import com.jeongyuneo.softdelete.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
