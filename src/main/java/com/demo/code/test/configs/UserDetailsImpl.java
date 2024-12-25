package com.demo.code.test.configs;


import com.demo.code.test.entity.User;
import com.demo.code.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;

//    public UserDetailsImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByusername(username).orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole())));
//        return org.springframework.security.core.userdetails.User.builder()
//                .username(user.getUsername())
//                .password(user.getPassword()) // Already encoded
//                .authorities("ROLE_" + user.getRole())
//                .roles(user.getRole()).build();
    }

//    public void addUser(String username, String password, String role) {
//        if (userRepository.findByusername(username).isPresent()) {
//            throw new IllegalArgumentException("User already exists: " + username);
//        }
//
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(passwordEncoder.encode(password)); // Encode the password
//        user.setRole(role); // Convert roles to a Set
//
//        userRepository.save(user);
//    }
}

