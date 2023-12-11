package com.michelinguide.daou.auth.service.impl;

import com.michelinguide.daou.auth.dtos.MemberDto;
import com.michelinguide.daou.auth.entity.Member;
import com.michelinguide.daou.auth.repository.MemberRepository;
import com.michelinguide.daou.auth.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public Long save(MemberDto.JoinRequest request) {
        Member savedMember = memberRepository.save(request.toEntity());
        return savedMember.getId();
    }
}
