package com.portoflio.back.services;

import com.portoflio.back.data.entities.AppRole;
import com.portoflio.back.data.entities.AppUser;

public interface ISecurityService {

    AppUser findUserByEmail(String email);
    AppRole findRoleByRolename(String rolename);
    AppUser saveUser(AppUser user);
    AppRole saveRole(String role);
    void addRoleToUser(String email,String rolename);
    AppUser findAdmin();
}
