package com.pitchIt.pitchIt.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.SecurityContextRepository;

public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(PasswordEncoder passwordEncoder) {
        UserDetails user = User.withUsername("admin")
        .password(passwordEncoder.encode("password"))
        .roles("ADMIN")
        .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        SecurityContextRepository repository = new CustomSecurityContextRepository();
        
        http.
            securityContext((context) -> {
                try {
                    context
                    .securityContextRepository(repository)
                    .and()
                    .authorizeRequests()
                    .antMatchers("/")
                    .hasAnyRole()
                    .anyRequest()
                    .authenticated();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
