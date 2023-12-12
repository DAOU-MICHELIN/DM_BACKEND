package com.michelinguide.daou.auth.token.service;

public interface RefreshTokenService {
    public void saveTokenInfo(String email, String accessToken, String refreshToken);

    public void removeRefreshToken(String accessToken);

}
