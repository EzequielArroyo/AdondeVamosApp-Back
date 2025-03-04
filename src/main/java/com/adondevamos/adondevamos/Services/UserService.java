package com.adondevamos.adondevamos.Services;


import com.adondevamos.adondevamos.Dto.UserDTO;

import com.adondevamos.adondevamos.Entities.User;

import com.adondevamos.adondevamos.Exception.EntityNotFoundException;
import com.adondevamos.adondevamos.Repositories.InterestRepository;
import com.adondevamos.adondevamos.Repositories.LanguageRepository;
import com.adondevamos.adondevamos.Repositories.UserRepository;
import com.adondevamos.adondevamos.utils.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LanguageRepository languageRepository;
    @Autowired
    private InterestRepository interestRepository;
    @Autowired
    private UserMapper userMapper;

    public List<UserDTO> getUsers() {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(user -> UserDTO.builder()
                        .username(user.getUsername())
                        .firstname(user.getFirstname())
                        .lastname(user.getLastname())
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

    }
    public UserDTO getUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException(username + " not found"));
        return userMapper.toDTO(user);
    }

    public UserDTO updateUser(String username, UserDTO updateData){
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException(username + " not found"));

        // UPDATING ATTRIBUTES TO THE EXISTING USER
        user.setUsername(updateData.getUsername());
        user.setEmail(updateData.getEmail());
        user.setFirstname(updateData.getFirstname());
        user.setLastname(updateData.getLastname());
        user.setBirthdate(updateData.getBirthdate());
        user.setSex(updateData.getSex());
        user.setPhone(updateData.getPhone());
        user.setLocation(updateData.getLocation());
        user.setBio(updateData.getBio());
        user.setOccupation(updateData.getOccupation());
        user.setLanguages(updateData.getLanguages());
        user.setInterests(updateData.getInterests());

        userRepository.save(user);

        return userMapper.toDTO(user);
    }
    public UserDTO deleteUser(String username){
        User user = userRepository.deleteUserByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException(username + " not found"));
        return userMapper.toDTO(user);
    }
    public UserDTO getProfile(User user){
        return userMapper.toDTO(user);
    }


}
