package com.adondevamos.adondevamos.Services;

import com.adondevamos.adondevamos.Dto.UserCreateDTO;
import com.adondevamos.adondevamos.Entities.User;
import com.adondevamos.adondevamos.Dto.UserResponseDTO;
import com.adondevamos.adondevamos.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserResponseDTO getUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserResponseDTO.builder()
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .birthdate(user.getBirthdate())
                .sex(user.getSex())
                .phone(user.getPhone())
                .location(user.getLocation())
                .languages(user.getLanguages())
                .bio(user.getBio())
                .occupation(user.getOccupation())
                .interests(user.getInterests())
                .build();
    }
    public UserResponseDTO createUser(UserCreateDTO request){
        User user = User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .birthdate(request.getBirthdate())
                .sex(request.getSex())
                .phone(request.getPhone())
                .location(request.getLocation())
                .languages(request.getLanguages())
                .bio(request.getBio())
                .occupation(request.getOccupation())
                .interests(request.getInterests())
                .build();

        userRepository.save(user);

        return UserResponseDTO.builder()
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .birthdate(user.getBirthdate())
                .sex(user.getSex())
                .phone(user.getPhone())
                .location(user.getLocation())
                .languages(user.getLanguages())
                .bio(user.getBio())
                .occupation(user.getOccupation())
                .interests(user.getInterests())
                .build();
    }

}
