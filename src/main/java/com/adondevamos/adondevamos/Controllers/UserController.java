package com.adondevamos.adondevamos.Controllers;

import com.adondevamos.adondevamos.Dto.UserCreateDTO;
import com.adondevamos.adondevamos.Dto.UserResponseDTO;
import com.adondevamos.adondevamos.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{username}")
    public UserResponseDTO getUserProfileByUsername(@PathVariable String username){
        return userService.getUserProfileByUsername(username);

    }
    @PostMapping
    public UserResponseDTO createUser(@RequestBody UserCreateDTO postRequest){
        return userService.createUser(postRequest);
    }
}
