package com.adondevamos.adondevamos.Services;

import com.adondevamos.adondevamos.Dtos.User.UserDTO;
import com.adondevamos.adondevamos.Entities.User;
import com.adondevamos.adondevamos.Entities.UserRequest;
import com.adondevamos.adondevamos.Repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //GET USER BY ID
    public UserDTO getUserById(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found"));
            return UserDTO.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .firstname(user.getFirstname())
                    .lastname(user.getLastname())
                    .email(user.getEmail())
                    .build();

    }

    //EDIT USER
    public String updateUser(Long id, UserRequest userRequest){
        User user = userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found"));
        user.setUsername(userRequest.getUsername());
        user.setFirstname(userRequest.getFirstname());
        user.setLastname(userRequest.getLastname());
        user.setEmail(userRequest.getEmail());
        userRepository.save(user);

        return "Usuario actualizado exitosamente";
    }

    //DELETE USER
    public void deleteUserById(Long userId){
        if(userRepository.existsById(userId)){
            userRepository.deleteById(userId);
        }else{
            throw new RuntimeException("User with ID " + userId + " not found");
        }
    }
}

