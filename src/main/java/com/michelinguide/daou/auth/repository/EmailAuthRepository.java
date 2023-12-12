package com.michelinguide.daou.auth.repository;

import com.michelinguide.daou.auth.entity.EmailAuth;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmailAuthRepository extends JpaRepository<EmailAuth , Long > {
    @Query(value = "select e from EmailAuth e where e.email = :email and e.expired = false and e.expiredDateTime >= CURRENT_TIMESTAMP")
    Optional<EmailAuth> findValidAuthCodeByEmail(String email);

}
