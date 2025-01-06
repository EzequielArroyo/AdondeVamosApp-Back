package com.adondevamos.adondevamos.Dtos.User;

import lombok.Data;

@Data
public class CreateUserDTO {
    private String userName;
    private String lastName;
    private String email;
    private String password;
}
