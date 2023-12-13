package com.michelinguide.daou.auth.service.impl;

import com.michelinguide.daou.auth.dtos.EmailDto;
import com.michelinguide.daou.auth.dtos.MemberDto;
import com.michelinguide.daou.auth.entity.Member;
import com.michelinguide.daou.auth.repository.MemberRepository;
import com.michelinguide.daou.auth.service.MemberService;
import com.michelinguide.daou.auth.util.RedisUtil;
import com.michelinguide.daou.common.handler.exception.CustomException;
import java.util.Optional;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    private final RedisUtil redisUtil;

    public Long save(MemberDto.JoinRequest request) {


        // TODO : 레디스 인증 코드 조회

        Member savedMember = memberRepository.save(request.toEntity());


        return savedMember.getId();
    }
    private void checkDuplicatedEmail(String email){
        Optional<Member> memberByEmail = memberRepository.findByEmail(email);
        if (memberByEmail.isPresent()){
            throw CustomException.duplicateEmailException();
        }
    }

    private String createCode() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for(int i = 0 ; i < 6; i ++){
            int index = random.nextInt(3);
            switch (index) {
                case 0:
                    sb.append((char) ((int) (random.nextInt(26)) + 97));
                    break;
                case 1:
                    sb.append((char) ((int) (random.nextInt(26)) + 65));
                    break;
                case 2:
                    sb.append((random.nextInt(10)));
                    break;
            }
        }
        return sb.toString();
    }

    public void delete(Long id) {
        memberRepository.deleteById(id);
    }

    public void confirmEmail(EmailDto.ConfirmRequest request) {

        // TODO : 이메일 중복 검사
        checkDuplicatedEmail(request.getEmail());

        String authCode = createCode();
        // TODO : 이메일 전송 하는 로직 연결

        redisUtil.setDataExpire(request.getEmail(), authCode, 60 *5L );

    }


}
