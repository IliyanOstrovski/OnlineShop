package com.project.onlineShop.services;

import com.project.onlineShop.models.User;
import com.project.onlineShop.models.dtos.RegistrationDTO;
import com.project.onlineShop.repositories.UserRepository;
import com.project.onlineShop.session.LoggedUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private UserRepository userRepository;
    private LoggedUser userSession;
    private PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, LoggedUser userSession, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userSession = userSession;
        this.passwordEncoder = passwordEncoder;
    }



    public boolean register(RegistrationDTO registrationDTO) {
        if (!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())) {
            return false;
        }

        Optional<User> byEmail = this.userRepository.findByEmail(registrationDTO.getEmail());
        if (byEmail.isPresent()){
            return false;
        }

        Optional<User> byUsername = this.userRepository.findByUsername(registrationDTO.getUsername());
        if (byUsername.isPresent()){
            return false;
        }


        User user = new User();
        user.setUsername(registrationDTO.getUsername());
        user.setEmail(registrationDTO.getEmail());
        //user.setPassword(registrationDTO.getPassword());
        user.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        this.userRepository.save(user);

        return true;
    }


}