package com.portoflio.back.data.repositories;

import com.portoflio.back.data.entities.ExpiredToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExpiredTokenRepository extends JpaRepository<ExpiredToken, Long> {
    ExpiredToken findByToken(String token);
}
