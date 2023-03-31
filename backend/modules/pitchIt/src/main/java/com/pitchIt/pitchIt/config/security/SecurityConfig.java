package com.pitchIt.pitchIt.config.security;

import org.springframework.context.annotation.Bean;

public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(PasswordEncoder passwordEncoder) {

    }
}
