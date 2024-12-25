package com.demo.code.test.controller;


import com.demo.code.test.dtos.LoginUserDto;
import com.demo.code.test.dtos.RegisterUserDto;
import com.demo.code.test.entity.User;
import com.demo.code.test.responses.LoginResponse;
import com.demo.code.test.service.AuthenticationService;
import com.demo.code.test.service.JwtService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @Operation(summary = "Add new user", description = "Add new user with username and password with role USER or ADMIN")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful User Added", content = @Content(schema = @Schema(implementation = AuthenticationController.AuthResponse.class))), @ApiResponse(responseCode = "401", description = "Invalid User", content = @Content(schema = @Schema(implementation = AuthenticationController.ErrorResponse.class)))})
    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @Operation(summary = "Login and generate JWT token", description = "Authenticate a user with username and password, and generate a JWT token.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful authentication", content = @Content(schema = @Schema(implementation = AuthenticationController.AuthResponse.class))), @ApiResponse(responseCode = "401", description = "Invalid username or password", content = @Content(schema = @Schema(implementation = AuthenticationController.ErrorResponse.class)))})
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }

    // Inner class for authentication response
    private record AuthResponse(String token) {
    }

    // Inner class for error response
    private record ErrorResponse(String message) {
    }
}