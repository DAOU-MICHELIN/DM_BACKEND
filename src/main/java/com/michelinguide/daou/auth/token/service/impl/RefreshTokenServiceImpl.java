package com.michelinguide.daou.auth.token.service.impl;

import com.michelinguide.daou.auth.token.RefreshToken;
import com.michelinguide.daou.auth.token.repository.RefreshTokenRepository;
import com.michelinguide.daou.auth.token.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    @Override
    public void saveTokenInfo(String email, String accessToken, String refreshToken) {
        refreshTokenRepository.save(RefreshToken.builder().id(email).accessToken(accessToken).refreshToken(refreshToken).build());
    }


    @Override
    public void removeRefreshToken(String accessToken) {
        RefreshToken refreshToken = refreshTokenRepository.findByAccessToken(accessToken).orElseThrow(IllegalAccessError::new);
        refreshTokenRepository.delete(refreshToken);
    }
}
