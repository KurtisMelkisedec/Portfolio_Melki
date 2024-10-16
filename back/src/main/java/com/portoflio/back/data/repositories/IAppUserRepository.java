package com.portoflio.back.data.repositories;

import com.portoflio.back.data.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByEmail(String email);
}
