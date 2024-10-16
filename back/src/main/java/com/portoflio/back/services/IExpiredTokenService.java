package com.portoflio.back.services;

import com.portoflio.back.data.entities.ExpiredToken;

public interface IExpiredTokenService {


    ExpiredToken findTokenInBlacklist(String token);

    ExpiredToken save(ExpiredToken token);
}
