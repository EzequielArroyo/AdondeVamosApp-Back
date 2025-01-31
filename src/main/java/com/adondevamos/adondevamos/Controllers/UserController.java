package com.adondevamos.adondevamos.Controllers;

import com.adondevamos.adondevamos.Dto.UserCreateDTO;
import com.adondevamos.adondevamos.Dto.UserResponseDTO;
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
    public ResponseEntity<List<UserResponseDTO>> getUsers(){
        List<UserResponseDTO> userList = userService.getUsers();
        return ResponseEntity.ok(userList);
    }
    @GetMapping("/{username}")
    public ResponseEntity<UserResponseDTO> getUserByUsername(@PathVariable String username){
         UserResponseDTO response = userService.getUserByUsername(username);
         return ResponseEntity.ok(response);

    }
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserCreateDTO postRequest){
        UserResponseDTO newUserResponse = userService.createUser(postRequest);
        return ResponseEntity.ok(newUserResponse);
    }
}
