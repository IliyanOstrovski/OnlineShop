package com.project.onlineShop.config;


import com.project.onlineShop.repositories.UserRepository;
import com.project.onlineShop.services.AppUserDetailsService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new Pbkdf2PasswordEncoder();
    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.
                authorizeRequests().

                        requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll().

                        antMatchers("/", "/login", "/register").permitAll().

                        anyRequest().

                authenticated().

                and().

                        formLogin().

                        loginPage("/login").

                        usernameParameter("username").

                        passwordParameter("password").

                        defaultSuccessUrl("/home").

                        failureForwardUrl("/").
                and().

                        logout().

                        logoutUrl("/").

                        invalidateHttpSession(true).
                deleteCookies("JSESSIONID");


        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new AppUserDetailsService(userRepository){};
    }
}
