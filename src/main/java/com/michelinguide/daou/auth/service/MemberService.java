package com.michelinguide.daou.auth.service;

import com.michelinguide.daou.auth.dtos.MemberDto;

public interface MemberService {

     Long save (MemberDto.JoinRequest request);

     void delete(Long id);

     void memberRegister(MemberDto.JoinRequest request);

}
