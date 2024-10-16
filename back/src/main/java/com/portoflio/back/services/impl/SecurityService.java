package com.portoflio.back.services.impl;

import com.portoflio.back.data.entities.AppRole;
import com.portoflio.back.data.entities.AppUser;
import com.portoflio.back.data.repositories.IAppRoleRepository;
import com.portoflio.back.data.repositories.IAppUserRepository;
import com.portoflio.back.exceptions.EntityNotFoundException;
import com.portoflio.back.services.ISecurityService;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SecurityService implements ISecurityService, UserDetailsService {
    private final IAppRoleRepository appRoleRepository;
    private final IAppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public AppUser findUserByEmail(String email) {
        return appUserRepository.findByEmail(email);
    }

    @Override
    public AppRole findRoleByRolename(String rolename) {
        return null;
    }

    @Override
    public AppUser saveUser(AppUser user) {
        AppUser appUser = findUserByEmail(user.getEmail());
        if(appUser != null) throw new EntityExistsException("User already exists");

        return appUserRepository.save(user);
    }

    @Override
    public AppRole saveRole(String role) {
        AppRole appRole = appRoleRepository.findByRoleName(role);
        if(appRole!=null)throw new EntityNotFoundException("Ce role n'existe pas");

        return null;
    }

    @Override
    public void addRoleToUser(String email, String rolename) {
        AppRole role = appRoleRepository.findByRoleName(rolename);
        if(role==null) throw new EntityNotFoundException("Ce role n'existe pas");
        AppUser user = appUserRepository.findByEmail(email);
        if(user==null) throw new EntityNotFoundException("Ce user n'existe pas");
        user.getRoles().add(role);
        appUserRepository.save(user);

    }

    @Override
    public AppUser findAdmin() {
        return appUserRepository.findById(1L).get();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = appUserRepository.findByEmail(username);
        if(user==null) throw new EntityNotFoundException("Ce user n'existe pas");
        List<SimpleGrantedAuthority>authorities = user.getRoles().stream().map(r->new SimpleGrantedAuthority(r.getRoleName())).toList();
        return new User(user.getEmail(), user.getPassword(), authorities);
    }
}
