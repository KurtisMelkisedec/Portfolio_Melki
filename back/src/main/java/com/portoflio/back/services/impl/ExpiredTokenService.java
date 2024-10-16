package com.portoflio.back.services.impl;

import com.portoflio.back.data.entities.ExpiredToken;
import com.portoflio.back.data.repositories.IExpiredTokenRepository;
import com.portoflio.back.services.IExpiredTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ExpiredTokenService implements IExpiredTokenService {
    private final IExpiredTokenRepository expiredTokenRepository;
    @Override
    public ExpiredToken findTokenInBlacklist(String token) {
        return expiredTokenRepository.findByToken(token);
    }

    @Override
    public ExpiredToken save(ExpiredToken token) {
        return expiredTokenRepository.save(token);
    }
}
