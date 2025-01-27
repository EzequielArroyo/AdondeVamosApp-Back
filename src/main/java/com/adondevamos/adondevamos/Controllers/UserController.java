package com.adondevamos.adondevamos.Controllers;

import com.adondevamos.adondevamos.Dtos.User.UserDTO;
import com.adondevamos.adondevamos.Entities.UserRequest;
import com.adondevamos.adondevamos.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
public class UserController {
    @Autowired
    private UserService userService;

    /*GET ALL USERS
    @GetMapping

    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    */

    //GET USER BY ID
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
       UserDTO user = userService.getUserById(id);
       return ResponseEntity.ok(user);
    }

    //EDIT USER
    @PostMapping(value = "/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserRequest userUpdated){
        String message = userService.updateUser(id, userUpdated);
        return ResponseEntity.ok(message);
    }
    //DELETE USER
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
