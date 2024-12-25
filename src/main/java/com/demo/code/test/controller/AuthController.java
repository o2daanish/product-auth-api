//package com.demo.code.test.controller;
//
//import com.demo.code.test.dtos.LoginUserDto;
//import com.demo.code.test.dtos.RegisterUserDto;
//import com.demo.code.test.configs.CustomUserDetailsService;
//import com.demo.code.test.util.JwtUtil;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/v1/auth")
//public class AuthController {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private CustomUserDetailsService userDetailsService;
//
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    @Operation(summary = "Login and generate JWT token", description = "Authenticate a user with username and password, and generate a JWT token.")
//    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful authentication", content = @Content(schema = @Schema(implementation = AuthResponse.class))), @ApiResponse(responseCode = "401", description = "Invalid username or password", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))})
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LoginUserDto login) {
//        try {
//            // Perform authentication
//            var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());
//            Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
//
//            org.springframework.security.core.userdetails.User authenticatedUser = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
//            List<String> roles = authenticatedUser.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
//
//            // Generate JWT token upon successful authentication
//            String token = jwtUtil.generateToken(authentication.getName(), roles);
//
//            // Return the token in a structured response
//            return ResponseEntity.ok(new AuthResponse(token));
//
//        } catch (AuthenticationException e) {
//            // Return 401 Unauthorized with a clear error message
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse("Invalid username or password"));
//        }
//    }
//
//    @Operation(summary = "Add new user", description = "Add new user with username and password with role USER or ADMIN")
//    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful User Added", content = @Content(schema = @Schema(implementation = AuthResponse.class))), @ApiResponse(responseCode = "401", description = "Invalid User", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))})
//    @PostMapping("/add")
//    public ResponseEntity<String> addUser(@RequestBody RegisterUserDto login) {
//        try {
//            userDetailsService.addUser(login.getUserName(), login.getPassword(), login.getRole());
//            return ResponseEntity.status(HttpStatus.CREATED).body("User added successfully: " + login.getUserName());
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
//        }
//    }
//
//    @GetMapping("/exists/{username}")
//    public ResponseEntity<Boolean> userExists(@PathVariable String username) {
//        return ResponseEntity.ok(userDetailsService.userExists(username));
//    }
//
//    // Inner class for authentication response
//    private record AuthResponse(String token) {
//    }
//
//    // Inner class for error response
//    private record ErrorResponse(String message) {
//    }
//}
