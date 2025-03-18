package com.adondevamos.adondevamos.Auth;



import com.adondevamos.adondevamos.core.Category.Category;
import com.adondevamos.adondevamos.core.Category.CategoryRepository;

import com.adondevamos.adondevamos.core.Language.Language;
import com.adondevamos.adondevamos.core.User.User;
import com.adondevamos.adondevamos.Exception.EntityAlreadyExistsException;
import com.adondevamos.adondevamos.Exception.EntityNotFoundException;
import com.adondevamos.adondevamos.Jwt.JwtService;

import com.adondevamos.adondevamos.core.Language.LanguageRepository;
import com.adondevamos.adondevamos.core.User.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private  final CategoryRepository categoryRepository;
    private final LanguageRepository languageRepository;



    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        User user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.generateToken(user);
        return AuthResponse.builder()
                .isSuccess(true)
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest newUserRequest) {
        if(userRepository.findByUsername(newUserRequest.getUsername()).isPresent()){
            throw new EntityAlreadyExistsException("Username: " + newUserRequest.getUsername() + " already exists");
        }
        if(userRepository.findByEmail(newUserRequest.getEmail()).isPresent()){
            throw new EntityAlreadyExistsException("Email: " + newUserRequest.getEmail() + " already exists");
        }
        List<Language> languages = newUserRequest.getLanguages().stream()
                .map(languageDTO -> languageRepository.findById(languageDTO.getId())
                        .orElseThrow(() -> new EntityNotFoundException(languageDTO.getName() + " not found")))
                .collect(Collectors.toList());

        List<Category> categories = newUserRequest.getCategories().stream()
                .map(categoryDTO -> categoryRepository.findById(categoryDTO.getId())
                        .orElseThrow(() -> new EntityNotFoundException(categoryDTO.getName() + " not found")))
                .toList();

        User user = User.builder()
                .username(newUserRequest.getUsername())
                .email(newUserRequest.getEmail())
                .password(passwordEncoder.encode(newUserRequest.getPassword()))
                .firstname(newUserRequest.getFirstname())
                .lastname(newUserRequest.getLastname())
                .birthdate(newUserRequest.getBirthdate())
                .sex(newUserRequest.getSex())
                .phone(newUserRequest.getPhone())
                .location(newUserRequest.getLocation())
                .bio(newUserRequest.getBio())
                .occupation(newUserRequest.getOccupation())
                .languages(languages)
                .categories(categories)
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .isSuccess(true)
                .build();
    }

    public Boolean validateToken(String token) {
        if (token == null || token.isBlank()) {
            System.out.println("🚨 Token is null or empty");
            return false;
        }

        String username = jwtService.getUsernameFromToken(token);
        if (username == null) {
            System.out.println("🚨 Username from token is null");
            return false;
        }

        // Evita problemas con sesiones previas
        SecurityContextHolder.clearContext();

        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            boolean isValid = jwtService.isTokenValid(token, userDetails);

            System.out.println("🔍 Token: " + token);
            System.out.println("🔍 Username from token: " + username);
            System.out.println("🔍 UserDetails username: " + userDetails.getUsername());
            System.out.println("✅ Token valid: " + isValid);

            return isValid;
        } catch (Exception e) {
            System.out.println("🚨 Error during token validation: " + e.getMessage());
            return false;
        }
    }
}