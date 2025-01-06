package com.adondevamos.adondevamos.Services;

import com.adondevamos.adondevamos.Dtos.User.CreateUserDTO;
import com.adondevamos.adondevamos.Dtos.User.UserDTO;
import com.adondevamos.adondevamos.Entities.User;
import com.adondevamos.adondevamos.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //GET ALL USERS
    public List<UserDTO> getAllUsers(){
        return  userRepository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
    }

    //GET USER BY ID
    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found"));
    }

    //CREATE USER
    public CreateUserDTO createUser(CreateUserDTO newUser) {
        User user = new User();
        user.setUserName(newUser.getUserName());
        user.setLastName(newUser.getLastName());
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassword());

        // Guardar el usuario en la base de datos
        User savedUser = userRepository.save(user);
        return newUser;
    }

    //EDIT USER
    public User updateUser(Long id, User updatePost){
        User user = userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found"));
        if(updatePost.getUserName() != null){
            user.setUserName(updatePost.getUserName());
        }
        if(updatePost.getEmail() != null){
            user.setEmail(updatePost.getEmail());
        }
        if(updatePost.getPassword() != null){
            user.setPassword(updatePost.getPassword());
        }
        return userRepository.save(user);
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

