package com.kodigoApplaudo.group2.bankingSpring.Services;

import com.kodigoApplaudo.group2.bankingSpring.Model.Manager;
import com.kodigoApplaudo.group2.bankingSpring.Repository.ManagerRepository;
import com.kodigoApplaudo.group2.bankingSpring.domain.Role;
import com.kodigoApplaudo.group2.bankingSpring.domain.User;
import com.kodigoApplaudo.group2.bankingSpring.Repository.RoleRepository;
import com.kodigoApplaudo.group2.bankingSpring.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    private  final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final ManagerRepository managerRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            log.error("User not found.");
            throw new UsernameNotFoundException("User not found.");
        } else {
            log.info("User found in database: {}",username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }

    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to the database", user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Manager saveManager(Manager manager) {
        log.info("Saving new manager {} to the database", manager.getUsername());
        return managerRepository.save(manager);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String role_name) {
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(role_name);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
