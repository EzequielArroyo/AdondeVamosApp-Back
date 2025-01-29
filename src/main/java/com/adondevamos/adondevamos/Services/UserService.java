package com.adondevamos.adondevamos.Services;

import com.adondevamos.adondevamos.Dto.UserCreateDTO;
import com.adondevamos.adondevamos.Entities.Interest;
import com.adondevamos.adondevamos.Entities.Language;
import com.adondevamos.adondevamos.Entities.User;
import com.adondevamos.adondevamos.Dto.UserResponseDTO;
import com.adondevamos.adondevamos.Repositories.InterestRepository;
import com.adondevamos.adondevamos.Repositories.LanguageRepository;
import com.adondevamos.adondevamos.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LanguageRepository languageRepository;
    @Autowired
    private InterestRepository interestRepository;

    public UserResponseDTO getUserProfileByUsername(String username) {
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

    @Transactional
    public UserResponseDTO createUser(UserCreateDTO request){
        List<Language> languages = request.getLanguages().stream()
                .map(languageDTO -> languageRepository.findById(languageDTO.getId())
                        .orElseThrow(() -> new RuntimeException("Language not found with ID: " + languageDTO.getId())))
                .collect(Collectors.toList());
        List<Interest> interests = request.getInterests().stream()
                .map(interestDTO -> interestRepository.findById(interestDTO.getId())
                        .orElseThrow(() -> new RuntimeException("Language not found with ID: " + interestDTO.getId())))
                .collect(Collectors.toList());

        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .birthdate(request.getBirthdate())
                .sex(request.getSex())
                .phone(request.getPhone())
                .location(request.getLocation())
                .bio(request.getBio())
                .occupation(request.getOccupation())
                .languages(languages)
                .interests(interests)
                .build();

        userRepository.save(user);

        return UserResponseDTO.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .birthdate(user.getBirthdate())
                .sex(user.getSex())
                .phone(user.getPhone())
                .location(user.getLocation())
                .bio(user.getBio())
                .occupation(user.getOccupation())
                .languages(user.getLanguages())
                .interests(user.getInterests())
                .build();
    }

}
