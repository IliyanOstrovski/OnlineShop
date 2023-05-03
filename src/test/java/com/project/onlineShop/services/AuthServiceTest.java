package com.project.onlineShop.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.project.onlineShop.models.User;
import com.project.onlineShop.models.dtos.RegistrationDTO;
import com.project.onlineShop.repositories.UserRepository;
import com.project.onlineShop.session.LoggedUser;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AuthService.class})
@ExtendWith(SpringExtension.class)
class AuthServiceTest {
    @Autowired
    private AuthService authService;

    @MockBean
    private LoggedUser loggedUser;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private UserRepository userRepository;

    /**
     * Method under test: {@link AuthService#register(RegistrationDTO)}
     */
    @Test
    void testRegister() {
        User user = new User();
        user.setBasketProducts(new ArrayList<>());
        user.setEmail("jane.doe@example.org");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setUserRoles(new ArrayList<>());
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setBasketProducts(new ArrayList<>());
        user1.setEmail("jane.doe@example.org");
        user1.setId(123L);
        user1.setPassword("iloveyou");
        user1.setUserRoles(new ArrayList<>());
        user1.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user1);

        User user2 = new User();
        user2.setBasketProducts(new ArrayList<>());
        user2.setEmail("jane.doe@example.org");
        user2.setId(123L);
        user2.setPassword("iloveyou");
        user2.setUserRoles(new ArrayList<>());
        user2.setUsername("janedoe");
        Optional<User> ofResult1 = Optional.of(user2);
        when(userRepository.save((User) any())).thenReturn(user);
        when(userRepository.findByEmail((String) any())).thenReturn(ofResult);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult1);

        RegistrationDTO registrationDTO = new RegistrationDTO();
        registrationDTO.setConfirmPassword("iloveyou");
        registrationDTO.setEmail("jane.doe@example.org");
        registrationDTO.setPassword("iloveyou");
        registrationDTO.setUsername("janedoe");
        assertFalse(authService.register(registrationDTO));
        verify(userRepository).findByEmail((String) any());
    }

    /**
     * Method under test: {@link AuthService#register(RegistrationDTO)}
     */
    @Test
    void testRegister2() {
        User user = new User();
        user.setBasketProducts(new ArrayList<>());
        user.setEmail("jane.doe@example.org");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setUserRoles(new ArrayList<>());
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setBasketProducts(new ArrayList<>());
        user1.setEmail("jane.doe@example.org");
        user1.setId(123L);
        user1.setPassword("iloveyou");
        user1.setUserRoles(new ArrayList<>());
        user1.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user1);
        when(userRepository.save((User) any())).thenReturn(user);
        when(userRepository.findByEmail((String) any())).thenReturn(Optional.empty());
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult);

        RegistrationDTO registrationDTO = new RegistrationDTO();
        registrationDTO.setConfirmPassword("iloveyou");
        registrationDTO.setEmail("jane.doe@example.org");
        registrationDTO.setPassword("iloveyou");
        registrationDTO.setUsername("janedoe");
        assertFalse(authService.register(registrationDTO));
        verify(userRepository).findByEmail((String) any());
        verify(userRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link AuthService#register(RegistrationDTO)}
     */
    @Test
    void testRegister3() {
        User user = new User();
        user.setBasketProducts(new ArrayList<>());
        user.setEmail("jane.doe@example.org");
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setUserRoles(new ArrayList<>());
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setBasketProducts(new ArrayList<>());
        user1.setEmail("jane.doe@example.org");
        user1.setId(123L);
        user1.setPassword("iloveyou");
        user1.setUserRoles(new ArrayList<>());
        user1.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user1);

        User user2 = new User();
        user2.setBasketProducts(new ArrayList<>());
        user2.setEmail("jane.doe@example.org");
        user2.setId(123L);
        user2.setPassword("iloveyou");
        user2.setUserRoles(new ArrayList<>());
        user2.setUsername("janedoe");
        Optional<User> ofResult1 = Optional.of(user2);
        when(userRepository.save((User) any())).thenReturn(user);
        when(userRepository.findByEmail((String) any())).thenReturn(ofResult);
        when(userRepository.findByUsername((String) any())).thenReturn(ofResult1);
        RegistrationDTO registrationDTO = mock(RegistrationDTO.class);
        when(registrationDTO.getConfirmPassword()).thenReturn("foo");
        when(registrationDTO.getPassword()).thenReturn("iloveyou");
        doNothing().when(registrationDTO).setConfirmPassword((String) any());
        doNothing().when(registrationDTO).setEmail((String) any());
        doNothing().when(registrationDTO).setPassword((String) any());
        doNothing().when(registrationDTO).setUsername((String) any());
        registrationDTO.setConfirmPassword("iloveyou");
        registrationDTO.setEmail("jane.doe@example.org");
        registrationDTO.setPassword("iloveyou");
        registrationDTO.setUsername("janedoe");
        assertFalse(authService.register(registrationDTO));
        verify(registrationDTO).getConfirmPassword();
        verify(registrationDTO).getPassword();
        verify(registrationDTO).setConfirmPassword((String) any());
        verify(registrationDTO).setEmail((String) any());
        verify(registrationDTO).setPassword((String) any());
        verify(registrationDTO).setUsername((String) any());
    }
}

