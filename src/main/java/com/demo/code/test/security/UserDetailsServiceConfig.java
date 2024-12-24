//package com.demo.code.test.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@Configuration
//public class UserDetailsServiceConfig {
//
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user = User.builder().username("admin").password(passwordEncoder().encode("password")) // Use encoded passwords
//                .roles("ADMIN").build();
//
//        UserDetails user2 = User.builder().username("user").password(passwordEncoder().encode("password")) // Another user with a different role
//                .roles("USER").build();
//
//        return new InMemoryUserDetailsManager(user, user2);
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
//
