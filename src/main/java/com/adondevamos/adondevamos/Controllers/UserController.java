package com.adondevamos.adondevamos.Controllers;

import com.adondevamos.adondevamos.Dtos.User.CreateUserDTO;
import com.adondevamos.adondevamos.Dtos.User.UserDTO;
import com.adondevamos.adondevamos.Entities.User;
import com.adondevamos.adondevamos.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    //GET ALL USERS
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    //GET USER BY ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
       User user = userService.getUserById(id);
       return ResponseEntity.ok(user);
    }

    //CREATE USER
    @PostMapping
    public ResponseEntity<CreateUserDTO> createUser(@RequestBody CreateUserDTO request){
        CreateUserDTO createdUser = userService.createUser(request);
        return ResponseEntity.ok(createdUser);
    }

    //EDIT USER
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userUpdated){
        User updatedUser = userService.updateUser(id, userUpdated);
        return ResponseEntity.ok(updatedUser);
    }
    //DELETE USER
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
