package com.adondevamos.adondevamos.Auth;

import com.adondevamos.adondevamos.Dtos.User.UserDTO;
import com.adondevamos.adondevamos.Entities.Role;
import com.adondevamos.adondevamos.Entities.User;
import com.adondevamos.adondevamos.Jwt.JwtService;
import com.adondevamos.adondevamos.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        User user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        UserDTO userData = UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .build();
        return AuthResponse.builder()
                .token(token)
                .userData(userData)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode( request.getPassword()))
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .role(Role.USER)
                .joinedPost(null)
                .build();
        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
    public UserDTO getUserByUsername(String username){

        User user = userRepository.findByUsername(username).orElseThrow();

        return UserDTO.builder()
               .id(user.getId())
               .username(user.getUsername())
               .firstname(user.getFirstname())
               .lastname(user.getLastname())
               .email(user.getEmail())
               .build();
    }
}
