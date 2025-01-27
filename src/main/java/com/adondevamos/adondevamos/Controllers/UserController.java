package com.adondevamos.adondevamos.Controllers;

import com.adondevamos.adondevamos.Dto.UserCreateDTO;
import com.adondevamos.adondevamos.Dto.UserResponseDTO;
import com.adondevamos.adondevamos.Services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    @GetMapping("/{username}")
    public UserResponseDTO getUserByUsername(@PathVariable String username){
        return userService.getUserByUsername(username);

    }
    @PostMapping
    public UserResponseDTO createUser(@RequestBody UserCreateDTO postRequest){
        return userService.createUser(postRequest);
    }
}
