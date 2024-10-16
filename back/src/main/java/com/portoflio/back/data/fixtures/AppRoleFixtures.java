package com.portoflio.back.data.fixtures;

import com.portoflio.back.data.entities.AppRole;
import com.portoflio.back.data.repositories.IAppRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
@Profile("prod")
@RequiredArgsConstructor
@Order(1)
public class AppRoleFixtures implements CommandLineRunner {
    private final IAppRoleRepository appRoleRepository;
    @Override
    public void run(String... args) throws Exception {
        AppRole appRole = new AppRole();
        appRole.setRoleName("Admin");
        appRoleRepository.save(appRole);
    }
}
