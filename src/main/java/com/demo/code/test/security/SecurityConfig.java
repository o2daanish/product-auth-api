//package com.demo.code.test.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http.csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
////                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()))
////                //.csrf(AbstractHttpConfigurer::disable) // Disable CSRF for simplicity (not recommended for production)
////                .authorizeHttpRequests(auth ->
////                        auth.requestMatchers("/h2-console/**").permitAll() // Allow access to H2 Console
////                        .requestMatchers("/api/public/**").permitAll() // Allow public access
////                                .requestMatchers("/api/v1/users/**").permitAll()
////                        .anyRequest().authenticated() // Secure other endpoints
////                ).httpBasic(httpBasic -> httpBasic.realmName("MyApp")); // Enable Basic Auth with a custom realm name
////        return http.build();
////    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable) // Disable CSRF if not needed
//                .authorizeHttpRequests(auth -> auth
//                        .anyRequest().authenticated() // Secure all endpoints
//                )
//                .httpBasic(httpBasic -> {}); // Enable HTTP Basic authentication
//
//        return http.build();
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(); // Use BCrypt to encode passwords
//    }
//}
//
//
