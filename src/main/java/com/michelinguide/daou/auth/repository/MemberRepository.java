package com.michelinguide.daou.auth.repository;

import com.michelinguide.daou.auth.entity.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {


}
