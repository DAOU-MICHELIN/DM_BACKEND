package com.michelinguide.daou.auth.repository;

import com.michelinguide.daou.auth.entity.Member;
import java.util.Optional;
import java.util.OptionalInt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);

}
