package com.michelinguide.daou.auth.service.impl;

import com.michelinguide.daou.auth.dtos.EmailDto;
import com.michelinguide.daou.auth.dtos.MemberDto;
import com.michelinguide.daou.auth.entity.EmailAuth;
import com.michelinguide.daou.auth.entity.Member;
import com.michelinguide.daou.auth.repository.EmailAuthRepository;
import com.michelinguide.daou.auth.repository.MemberRepository;
import com.michelinguide.daou.auth.service.MemberService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    private final EmailAuthRepository emailAuthRepository;

    public Long save(MemberDto.JoinRequest request) {
        // TODO :  이메일 중복 체크 및 도메인 체크


        EmailAuth emailAuth = EmailAuth.builder()
                                   .email(request.getEmail())
                                   .authCode(UUID.randomUUID().toString())
                                   .build();

        emailAuthRepository.save(emailAuth);
        Member savedMember = memberRepository.save(request.toEntity());

        // TODO : 이메일 발송 로직 추가

        return savedMember.getId();
    }

    public void delete(Long id) {
        memberRepository.deleteById(id);
    }

    @Transactional
    public void confirmEmail(EmailDto.ConfirmRequest request) {

        // TODO : 커스텀 exception 개발
        EmailAuth validEmailAuthByEmail = emailAuthRepository.findValidAuthCodeByEmail(request.getEmail())
                                                             .orElseThrow(() -> new RuntimeException("Valid email auth not found for email: " + request.getEmail()));

        // TODO : 커스텀 exception 개발
        Member member = memberRepository.findByEmail(request.getEmail()).orElseThrow();

        member.verifyEmail();

        validEmailAuthByEmail.useToken();

    }


}
