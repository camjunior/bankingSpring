package com.kodigoApplaudo.group2.bankingSpring.Services;

import com.kodigoApplaudo.group2.bankingSpring.Model.Manager;
import com.kodigoApplaudo.group2.bankingSpring.domain.Role;
import com.kodigoApplaudo.group2.bankingSpring.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String role_name);
    User getUser(String username);
    List<User> getUsers();

    Manager saveManager(Manager manager);
}
