//package com.demo.code.test.configs;
//
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.ConcurrentMap;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//    public static final String ADMIN = "ADMIN";
//    public static final String USER = "USER";
//    public static final String DEFAULT_PASSWORD = "password";
//    public static final String BCRYPT = "{bcrypt}";
//
//    // Hardcoded users (username -> UserDetails)
////    private final Map<String, UserDetails> users = Map.of(
////            "admin", User.builder()
////                    .username("admin")
////                    .password("{bcrypt}$2a$12$Ntw6LVfqrhVi7kdxQa.02OQGz4qKnzoiZu7Gq9xFJG9ZlXTmabMBS") // "password" (hashed with BCrypt)
////                    .roles("ADMIN")
////                    .build(),
////            "user", User.builder()
////                    .username("user")
////                    .password("{bcrypt}$2a$12$Ntw6LVfqrhVi7kdxQa.02OQGz4qKnzoiZu7Gq9xFJG9ZlXTmabMBS") // "password" (hashed with BCrypt)
////                    .roles("USER")
////                    .build()
////    );
////
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        // Lookup user in the hardcoded map
//        UserDetails userDetails = users.get(username);
//        if (userDetails == null) {
//            throw new UsernameNotFoundException("User not found: " + username);
//        }
//        return userDetails;
//    }
//
//
//    private final ConcurrentMap<String, UserDetails> users = new ConcurrentHashMap<>();
//    private final BCryptPasswordEncoder passwordEncoder;
//
//    public CustomUserDetailsService(BCryptPasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//
//        //Initialize with hardcoded users
////        var password = passwordEncoder.encode(PASSWORD);
////        users.put("admin", User.builder().username("admin").password(password) // Encode "password"
////                .roles(ADMIN).build());
////
////        users.put("user", User.builder().username("user").password(password) // Encode "password"
////                .roles(USER).build());
//        addUser("admin", DEFAULT_PASSWORD, "ADMIN");
//        addUser("user", DEFAULT_PASSWORD, "USER");
//    }
//
////    @Override
////    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////        UserDetails userDetails = users.get(username);
////        if (userDetails == null) {
////            throw new UsernameNotFoundException("User not found: " + username);
////        }
////        return userDetails;
////    }
//
//    public void addUser(String username, String password, String... roles) {
//        if (users.containsKey(username)) {
//            throw new IllegalArgumentException("User already exists: " + username);
//        }
//
//        var encode = passwordEncoder.encode(DEFAULT_PASSWORD);
//        users.put(username, User.builder().username(username).password(encode) // Encode the password
//                .roles(roles).build());
//    }
//
//    public boolean userExists(String username) {
//        return users.containsKey(username);
//    }
//}
//
//
//
//
