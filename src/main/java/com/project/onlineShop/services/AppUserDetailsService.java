package com.project.onlineShop.services;

import com.project.onlineShop.models.User;
import com.project.onlineShop.models.UserRole;
import com.project.onlineShop.models.dtos.RegistrationDTO;
import com.project.onlineShop.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.management.relation.Role;
import java.util.List;

public class AppUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.
                findByUsername(username).
                map(this::map).
                orElseThrow(() -> new UsernameNotFoundException("User with email " + username + " not found."));
    }

    private UserDetails map(User user){
        return org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities((user.getUserRoles().stream().map(this::authorityMap).toList())).build();
    }

    private GrantedAuthority authorityMap(UserRole role){
        return new SimpleGrantedAuthority("ROLE_" + role.getUserRole().name());
    }
}
