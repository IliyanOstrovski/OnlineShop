package com.project.onlineShop.services;

import com.project.onlineShop.models.User;
import com.project.onlineShop.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.mockito.Mockito.when;


@SpringBootTest
public class AppUserServiceTest {

    @Mock
    private UserDetailsService mockService;

    @Mock
    private UserRepository mockRepo;

    @Mock
    private User user;


    @BeforeEach
    void setUp(){
        mockService = new AppUserDetailsService(
                mockRepo
        );
    }

    @Test
    void loadUserByUsername(){
        User testUser = new User();
        testUser.setUsername("iliyan");
        testUser.setPassword("1111");

        when(mockRepo.findByUsername(testUser.getUsername())).thenReturn(Optional.of(testUser));
        UserDetails userDetails = mockService.loadUserByUsername(testUser.getUsername());
        Assertions.assertEquals(testUser.getUsername(), userDetails.getUsername());
    }



    @Test
    void testLoadUserByUsernameNonExist(){
        boolean thrown = false;
        when(mockRepo.findByUsername("NonExist")).thenThrow(new UsernameNotFoundException("No user"));

        try {
            UserDetails userDetails = mockService.loadUserByUsername("NonExist");
        }catch (UsernameNotFoundException e){
            thrown=true;
        }
        Assertions.assertTrue(thrown);
    }


    @Test
    void testUserNotFound(){
       Assertions.assertThrows(UsernameNotFoundException.class,
               () -> mockService.loadUserByUsername("invalid_email_user"));
    }

}
