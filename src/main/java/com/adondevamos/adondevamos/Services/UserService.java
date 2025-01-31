package com.adondevamos.adondevamos.Services;

import com.adondevamos.adondevamos.Dto.UserCreateDTO;
import com.adondevamos.adondevamos.Entities.Interest;
import com.adondevamos.adondevamos.Entities.Language;
import com.adondevamos.adondevamos.Entities.User;
import com.adondevamos.adondevamos.Dto.UserResponseDTO;
import com.adondevamos.adondevamos.Exception.EntityAlreadyExistsException;
import com.adondevamos.adondevamos.Exception.EntityNotFoundException;
import com.adondevamos.adondevamos.Repositories.InterestRepository;
import com.adondevamos.adondevamos.Repositories.LanguageRepository;
import com.adondevamos.adondevamos.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

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

    public List<UserResponseDTO> getUsers() {
        List<User> userList = userRepository.findAll();
        List<UserResponseDTO> userResponseList = userList.stream()
                .map(user -> UserResponseDTO.builder()
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
                        .build()).toList();
        return userResponseList;

    }
    public UserResponseDTO getUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException(username + " not found"));
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
    public UserResponseDTO createUser(UserCreateDTO newUserRequest){
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

        List<Interest> interests = newUserRequest.getInterests().stream()
                .map(interestDTO -> interestRepository.findById(interestDTO.getId())
                        .orElseThrow(() -> new EntityNotFoundException(interestDTO.getName() + " not found")))
                .collect(Collectors.toList());

        User user = User.builder()
                .username(newUserRequest.getUsername())
                .email(newUserRequest.getEmail())
                .password(newUserRequest.getPassword())
                .firstName(newUserRequest.getFirstName())
                .lastName(newUserRequest.getLastName())
                .birthdate(newUserRequest.getBirthdate())
                .sex(newUserRequest.getSex())
                .phone(newUserRequest.getPhone())
                .location(newUserRequest.getLocation())
                .bio(newUserRequest.getBio())
                .occupation(newUserRequest.getOccupation())
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
