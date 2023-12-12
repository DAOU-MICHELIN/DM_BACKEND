package com.michelinguide.daou.auth.token.repository;

import com.michelinguide.daou.auth.token.RefreshToken;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken,String > {

    Optional<RefreshToken>  findByAccessToken(String accessToken);

}
