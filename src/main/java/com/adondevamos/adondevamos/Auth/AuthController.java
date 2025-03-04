package com.adondevamos.adondevamos.Auth;

import com.adondevamos.adondevamos.Dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = {"http://localhost:4200"})
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }
    @PostMapping(value = "/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }
    @GetMapping("/user")
    public ResponseEntity<UserDTO> getUserData(Authentication  authentication) {
        UserDTO user = authService.getUserProfile(authentication.getName());
        return ResponseEntity.ok(user);
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