package com.adondevamos.adondevamos.Auth;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }
    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }
    @GetMapping(value = "/authenticate/{token}")
    public ResponseEntity<AuthenticationResponse> validateToken(@PathVariable String token){
        boolean validToken = authService.validateToken(token);
        AuthenticationResponse response = AuthenticationResponse.builder()
                .authenticate(validToken)
                .build();
        return ResponseEntity.ok(response);
    }

}