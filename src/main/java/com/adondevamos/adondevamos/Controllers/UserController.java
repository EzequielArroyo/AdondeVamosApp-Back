package com.adondevamos.adondevamos.Controllers;

import com.adondevamos.adondevamos.Dto.UserCreateDTO;

import com.adondevamos.adondevamos.Dto.UserDTO;
import com.adondevamos.adondevamos.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers(){
        List<UserDTO> userList = userService.getUsers();
        return ResponseEntity.ok(userList);
    }
    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username){
        UserDTO response = userService.getUserByUsername(username);
         return ResponseEntity.ok(response);

    }
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserCreateDTO postRequest){
        UserDTO newUserResponse = userService.createUser(postRequest);
        return ResponseEntity.ok(newUserResponse);
    }
    @PutMapping("/{username}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable String username, @RequestBody UserDTO userData){
        UserDTO updatedUserResponse = userService.updateUser(username, userData);
        return ResponseEntity.ok(updatedUserResponse);

    }
    @DeleteMapping("/{username}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable String username){
        UserDTO deletedUserResponse = userService.deleteUser(username);
        return  ResponseEntity.ok(deletedUserResponse);
    }
}
